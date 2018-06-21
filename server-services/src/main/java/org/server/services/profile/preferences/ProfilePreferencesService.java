package org.server.services.profile.preferences;

import org.server.core.dtos.social.SocialDetailDTO;
import org.server.core.entities.profile.preferences.ProfilePreferences;
import org.server.core.repositories.profile.preferences.ProfilePreferencesRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
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
