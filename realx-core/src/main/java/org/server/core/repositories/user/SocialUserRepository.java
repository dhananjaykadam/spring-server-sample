package org.server.core.repositories.user;

import java.util.List;

import org.server.core.entities.social.SocialUser;
import org.server.core.entities.user.User;
import org.server.core.enums.common.SocialMediaProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {
	public List<SocialUser> findByUserSocialId(String userId);

	public List<SocialUser> findByEmail(String email);

	public List<SocialUser> findByUserSocialIdOrEmailAndSocialMediaProvider(String userId, String email,
			SocialMediaProvider socialMediaProvider);

	public SocialUser findByUser(User user);
}
