package org.realx.security.repositories;

import java.util.List;

import org.realx.core.entities.user.User;
import org.realx.security.entities.groups.SecurityGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityGroupRepository extends JpaRepository<SecurityGroup, Long> {
	public List<SecurityGroup> findByUsersIn(User users);

	public List<SecurityGroup> findByGroupName(String name);
}
