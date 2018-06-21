package org.server.services.profile;

import java.util.List;

import org.server.core.dtos.social.SocialDetailDTO;
import org.server.core.entities.profile.common.ContactInfo;
import org.server.core.entities.profile.common.Profile;
import org.server.core.entities.profile.preferences.ProfilePreferences;
import org.server.core.entities.social.SocialUser;
import org.server.core.entities.user.User;
import org.server.core.enums.profile.ProfileType;
import org.server.core.repositories.profile.ProfileRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.server.services.profile.preferences.ProfilePreferencesService;
import org.server.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService extends DefaultJpaServiceImpl<Profile, Long, ProfileRepository>
		implements JpaService<Profile, Long> {
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private ContactInfoService contactInfoService;
	@Autowired
	private ProfilePreferencesService profilePreferencesService;

	public List<Profile> findByUserId(Long userId) {
		User user = getUserService().findById(userId);
		return getProfileRepository().findByUser(user);
	}

	public List<Profile> findByUser(User user) {
		return getProfileRepository().findByUser(user);
	}

	public List<Profile> findProfileByUsername(String userName) {
		User user = getUserService().findByUsername(userName);
		return getProfileRepository().findByUser(user);
	}

	public List<Profile> findProfileByUserAndProfileType(User user, ProfileType profileType) {
		return getProfileRepository().findByUserAndProfileType(user, profileType);
	}

	public Profile findSingleProfileByUserAndProfileType(User user, ProfileType profileType) {
		List<Profile> profiles = getProfileRepository().findByUserAndProfileType(user, profileType);
		if (profiles != null && !profiles.isEmpty()) {
			return profiles.get(0);
		}
		return null;
	}

	public ProfilePreferencesService getProfilePreferencesService() {
		return profilePreferencesService;
	}

	public void setProfilePreferencesService(ProfilePreferencesService profilePreferencesService) {
		this.profilePreferencesService = profilePreferencesService;
	}

	public ProfileRepository getProfileRepository() {
		return profileRepository;
	}

	public void setProfileRepository(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ContactInfoService getContactInfoService() {
		return contactInfoService;
	}

	public void setContactInfoService(ContactInfoService contactInfoService) {
		this.contactInfoService = contactInfoService;
	}

	public List<Profile> findProfileByEmail(String email) {
		return getProfileRepository().findByContactInfoEmail(email);
	}

	public Profile findSingleProfileByEmail(String email) {
		List<Profile> profiles = getProfileRepository().findByContactInfoEmail(email);
		if (profiles != null && !profiles.isEmpty()) {
			return profiles.get(0);
		}
		return null;
	}

	public Profile createNewProfile(Profile profile) {
		ContactInfo contactInfo = getContactInfoService().create(profile.getContactInfo());
		profile.setContactInfo(contactInfo);
		profile = getProfileRepository().save(profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		ContactInfo contactInfo = getContactInfoService().update(profile.getContactInfo());
		profile.setContactInfo(contactInfo);
		profile = getProfileRepository().save(profile);
		return profile;
	}

	public Profile createNewProfileForSocialUser(SocialUser socialUser, SocialDetailDTO socialDetailDTO) {
		ContactInfo contactInfo = getContactInfoService().createContactInfoForSocialUser(socialUser, socialDetailDTO);
		ProfilePreferences profilePreferences = getProfilePreferencesService()
				.addProfilePreferencesForSocialUserDTO(socialDetailDTO);
		Profile profile = new Profile();
		profile.setPreferences(profilePreferences);
		profile.setContactInfo(contactInfo);
		profile.setProfileType(ProfileType.CUSTOMER_PROFILE);
		profile.setUser(socialUser.getUser());
		profile.setDefault(true);
		profile = create(profile);
		return profile;
	}
}
