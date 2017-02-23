package org.realx.services.user;

import java.util.List;

import org.realx.core.dtos.social.SocialDetailDTO;
import org.realx.core.entities.profile.common.Profile;
import org.realx.core.entities.social.SocialUser;
import org.realx.core.entities.user.User;
import org.realx.core.entities.verification.otp.OTPVerification;
import org.realx.core.enums.common.SocialMediaProvider;
import org.realx.core.enums.common.UserType;
import org.realx.core.enums.profile.ProfileType;
import org.realx.core.enums.verification.otp.OTPVerificationStatus;
import org.realx.core.exceptions.handleradvice.BadRequestException;
import org.realx.core.repositories.user.SocialUserRepository;
import org.realx.security.services.SecurityManagerService;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.realx.services.external.social.SocialMediaService;
import org.realx.services.profile.ProfileService;
import org.realx.services.profile.customer.CustomerProfileService;
import org.realx.services.verification.otp.OTPDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialUserService extends DefaultJpaServiceImpl<SocialUser, Long, SocialUserRepository>
		implements JpaService<SocialUser, Long> {
	@Autowired
	private SocialUserRepository UserSocialAuthDetailRepository;
	@Autowired
	private SecurityManagerService securityManagerService;
	@Autowired
	private CustomerProfileService customerProfileService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private OTPDBService otpdbService;
	@Autowired
	private SocialMediaService socialMediaService;

	public SocialMediaService getSocialMediaService() {
		return socialMediaService;
	}

	public void setSocialMediaService(SocialMediaService socialMediaService) {
		this.socialMediaService = socialMediaService;
	}

	public OTPDBService getOtpdbService() {
		return otpdbService;
	}

	public void setOtpdbService(OTPDBService otpdbService) {
		this.otpdbService = otpdbService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public CustomerProfileService getCustomerProfileService() {
		return customerProfileService;
	}

	public void setCustomerProfileService(CustomerProfileService customerProfileService) {
		this.customerProfileService = customerProfileService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SecurityManagerService getSecurityManagerService() {
		return securityManagerService;
	}

	public void setSecurityManagerService(SecurityManagerService securityManagerService) {
		this.securityManagerService = securityManagerService;
	}

	public SocialUserRepository getUserSocialAuthDetailRepository() {
		return UserSocialAuthDetailRepository;
	}

	public void setUserSocialAuthDetailRepository(SocialUserRepository userSocialAuthDetailRepository) {
		UserSocialAuthDetailRepository = userSocialAuthDetailRepository;
	}

	public List<SocialUser> findBySocialIdOrEmailAndSocialMediaProvider(String userId, String email,
			SocialMediaProvider socialMediaProvider) {
		return getUserSocialAuthDetailRepository().findByUserSocialIdOrEmailAndSocialMediaProvider(userId, email,
				socialMediaProvider);
	}

	public SocialUser findByUser(User user) {
		return getUserSocialAuthDetailRepository().findByUser(user);
	}

	private void nullCheck(Object object, String message) throws BadRequestException {
		if (object == null) {
			throw new BadRequestException(message);
		}
	}

	private SocialUser buildUserFromUserSocialAuthDetail(SocialUser userSocialAuthDetail) throws BadRequestException {
		User user = new User();
		if (userSocialAuthDetail.getUserSocialId() != null && !userSocialAuthDetail.getUserSocialId().isEmpty()) {
			user.setUsername(userSocialAuthDetail.getUserSocialId());
		} else if (userSocialAuthDetail.getEmail() != null && !userSocialAuthDetail.getEmail().isEmpty()) {
			user.setUsername(userSocialAuthDetail.getEmail());
		} else {
			throw new BadRequestException("User email or Id not found");
		}
		user.setAuthorities(null);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);

		userSocialAuthDetail.setUser(user);
		return userSocialAuthDetail;
	}

	public SocialUser saveSocialUser(SocialUser userSocialAuthDetail, SocialDetailDTO socialDetailDTO) {
		nullCheck(userSocialAuthDetail, "Social User is null");
		List<SocialUser> userSocialAuthDetailDB = findBySocialIdOrEmailAndSocialMediaProvider(
				userSocialAuthDetail.getUserSocialId(), userSocialAuthDetail.getEmail(),
				userSocialAuthDetail.getSocialMediaProvider());
		if (userSocialAuthDetailDB != null && !userSocialAuthDetailDB.isEmpty()) {
			userSocialAuthDetail = userSocialAuthDetailDB.get(0);
		} else {
			userSocialAuthDetail = buildUserFromUserSocialAuthDetail(userSocialAuthDetail);
			User user = getUserService().create(userSocialAuthDetail.getUser());
			userSocialAuthDetail.setUser(user);
			SocialUser socialUser = create(userSocialAuthDetail);
			getCustomerProfileService().createNewCustomerProfileFromSocialUser(socialUser, socialDetailDTO);
			getSecurityManagerService().associateDefaultSecurityGroupToUsersByUserType(UserType.CUSTOMER, user);
		}
		return userSocialAuthDetail;
	}

	public OTPVerification verifySocialUserContactDetail(SocialUser socialUser) {
		Profile profile = getProfileService().findSingleProfileByUserAndProfileType(socialUser.getUser(),
				ProfileType.CUSTOMER_PROFILE);

		OTPVerification otpVerification = getOtpdbService().findVerificationDetailByContactNoAndStatus(
				profile.getContactInfo().getContactMobileNumber(),
				trimPlusSign(profile.getContactInfo().getContactMobileNumberCountryCode()),
				OTPVerificationStatus.VERIFIED);
		return otpVerification;
	}

	public SocialUser trySocialUserSilentLogin(SocialDetailDTO socialDetailDTO) {
		SocialUser socialUserGoogle = getSocialMediaService().getUserInfo(socialDetailDTO.getAccessToken(),
				socialDetailDTO.getSocialMediaProvider());
		if (socialUserGoogle != null) {
			List<SocialUser> sUsers = findBySocialIdOrEmailAndSocialMediaProvider(socialUserGoogle.getUserSocialId(),
					socialUserGoogle.getEmail(), socialDetailDTO.getSocialMediaProvider());
			if (sUsers != null && !sUsers.isEmpty()) {
				SocialUser socialUser = sUsers.get(0);
				OTPVerification otpVerification = verifySocialUserContactDetail(socialUser);
				if (otpVerification != null
						&& otpVerification.getVerificationStatus() == OTPVerificationStatus.VERIFIED) {
					getUserService().authenticateUser(socialUser.getUser());
					return socialUser;
				}
			}
		}
		return null;
	}

	public SocialUser trySocialUserLogin(SocialDetailDTO socialDetailDTO) {
		OTPVerification otpVerification = getOtpdbService().verifyPersistOtpProd(
				socialDetailDTO.getOtpObject().getContactNumber(),
				trimPlusSign(socialDetailDTO.getOtpObject().getCountryCode()), socialDetailDTO.getOtpObject().getOtp(),
				true);
		if (otpVerification != null && otpVerification.getVerificationStatus() == OTPVerificationStatus.VERIFIED) {
			SocialUser userSocialAuthDetail = getSocialMediaService().getUserInfo(socialDetailDTO.getAccessToken(),
					socialDetailDTO.getSocialMediaProvider());
			userSocialAuthDetail = saveSocialUser(userSocialAuthDetail, socialDetailDTO);
			getUserService().authenticateUser(userSocialAuthDetail.getUser());
			return userSocialAuthDetail;
		}
		return null;
	}

	private String trimPlusSign(String isoCode) {
		int a = Integer.parseInt(isoCode);
		return String.valueOf(a);
	}
}
