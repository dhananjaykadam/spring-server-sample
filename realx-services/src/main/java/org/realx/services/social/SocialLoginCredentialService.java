package org.realx.services.social;

import java.util.List;

import org.realx.core.entities.social.SocialMediaCredential;
import org.realx.core.enums.common.SocialMediaProvider;
import org.realx.core.repositories.social.SocialCredentialRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class SocialLoginCredentialService
		extends DefaultJpaServiceImpl<SocialMediaCredential, Long, SocialCredentialRepository>
		implements JpaService<SocialMediaCredential, Long> {
	@Autowired
	private SocialCredentialRepository socialLoginCredentialRepository;

	public SocialMediaCredential findBySocialMediaProviderAndEnabled(SocialMediaProvider socialMediaProvider,
			boolean enabled) {
		List<SocialMediaCredential> credentials = getSocialLoginCredentialRepository()
				.findBySocialMediaProviderAndEnabled(socialMediaProvider, enabled);
		if (credentials != null && !credentials.isEmpty())
			return credentials.get(0);
		return null;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<SocialMediaCredential> findAll() {
		return getSocialLoginCredentialRepository().findAll();
	}

	public SocialCredentialRepository getSocialLoginCredentialRepository() {
		return socialLoginCredentialRepository;
	}

	public void setSocialLoginCredentialRepository(SocialCredentialRepository socialLoginCredentialRepository) {
		this.socialLoginCredentialRepository = socialLoginCredentialRepository;
	}

}
