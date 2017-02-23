package org.realx.core.repositories.social;

import java.util.List;

import org.realx.core.entities.social.SocialMediaCredential;
import org.realx.core.enums.common.SocialMediaProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialCredentialRepository extends JpaRepository<SocialMediaCredential, Long> {
	public List<SocialMediaCredential> findBySocialMediaProviderAndEnabled(SocialMediaProvider socialMediaProvider,
			boolean enabled);
}
