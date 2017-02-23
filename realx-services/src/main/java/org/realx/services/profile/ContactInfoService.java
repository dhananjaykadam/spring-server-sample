package org.realx.services.profile;

import org.realx.core.dtos.social.SocialDetailDTO;
import org.realx.core.entities.profile.common.ContactInfo;
import org.realx.core.entities.social.SocialUser;
import org.realx.core.repositories.profile.ContactInfoRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoService extends DefaultJpaServiceImpl<ContactInfo, Long, ContactInfoRepository>
		implements JpaService<ContactInfo, Long> {

	public ContactInfo createContactInfoForSocialUser(SocialUser socialUser, SocialDetailDTO socialDetailDTO) {
		ContactInfo contactInfo = new ContactInfo();
		if (socialDetailDTO != null && socialDetailDTO.getOtpObject() != null) {
			contactInfo.setContactMobileNumber(socialDetailDTO.getOtpObject().getContactNumber());
			contactInfo.setContactMobileNumberCountryCode(socialDetailDTO.getOtpObject().getCountryCode());
		}
		contactInfo.setFirstName(socialUser.getFirstName());
		contactInfo.setLastName(socialUser.getLastName());
		contactInfo.setEmail(socialUser.getEmail());
		contactInfo = create(contactInfo);
		return contactInfo;
	}
}
