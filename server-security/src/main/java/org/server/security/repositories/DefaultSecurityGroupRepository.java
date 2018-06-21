package org.server.security.repositories;

import java.util.List;

import org.server.core.enums.common.UserType;
import org.server.security.entities.groups.DefaultSecurityGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultSecurityGroupRepository extends JpaRepository<DefaultSecurityGroup, Long> {
	public List<DefaultSecurityGroup> findByUserType(UserType userType);
}
