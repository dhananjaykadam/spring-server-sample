package org.server.core.repositories.social;

import java.util.List;

import org.server.core.entities.social.SocialMediaCredential;
import org.server.core.enums.common.SocialMediaProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialCredentialRepository extends JpaRepository<SocialMediaCredential, Long> {
	public List<SocialMediaCredential> findBySocialMediaProviderAndEnabled(SocialMediaProvider socialMediaProvider,
			boolean enabled);
}
