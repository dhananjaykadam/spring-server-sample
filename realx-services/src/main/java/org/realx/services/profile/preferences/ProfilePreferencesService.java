package org.realx.services.profile.preferences;

import org.realx.core.dtos.social.SocialDetailDTO;
import org.realx.core.entities.profile.preferences.ProfilePreferences;
import org.realx.core.repositories.profile.preferences.ProfilePreferencesRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class ProfilePreferencesService
		extends DefaultJpaServiceImpl<ProfilePreferences, Long, ProfilePreferencesRepository>
		implements JpaService<ProfilePreferences, Long> {
	public ProfilePreferences addProfilePreferencesForSocialUserDTO(SocialDetailDTO socialDetailDTO) {
		if (socialDetailDTO != null && socialDetailDTO.getTimeZoneOffset() != null) {
			ProfilePreferences preferences = new ProfilePreferences();
			preferences.setTimeZoneOffset(socialDetailDTO.getTimeZoneOffset());
			return create(preferences);
		}
		return null;
	}
}
