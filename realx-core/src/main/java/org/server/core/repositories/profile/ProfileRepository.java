package org.server.core.repositories.profile;

import java.util.List;

import org.server.core.entities.profile.common.Profile;
import org.server.core.entities.user.User;
import org.server.core.enums.profile.ProfileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	public List<Profile> findByUser(User user);

	public List<Profile> findByContactInfoEmail(String email);

	public List<Profile> findByUserAndProfileType(User user, ProfileType profileType);
}
