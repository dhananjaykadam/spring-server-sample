package org.server.core.repositories.profile;

import java.util.List;

import org.server.core.entities.profile.common.Profile;
import org.server.core.entities.profile.customer.CustomerProfile;
import org.server.core.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {
	public List<CustomerProfile> findByProfileUser(User user);

	public List<CustomerProfile> findByProfile(Profile profile);
}
