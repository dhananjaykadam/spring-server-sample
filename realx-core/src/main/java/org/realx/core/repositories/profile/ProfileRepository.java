package org.realx.core.repositories.profile;

import java.util.List;

import org.realx.core.entities.profile.common.Profile;
import org.realx.core.entities.user.User;
import org.realx.core.enums.profile.ProfileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	public List<Profile> findByUser(User user);

	public List<Profile> findByContactInfoEmail(String email);

	public List<Profile> findByUserAndProfileType(User user, ProfileType profileType);
}
