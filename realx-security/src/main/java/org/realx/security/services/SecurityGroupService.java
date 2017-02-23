package org.realx.security.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.realx.core.entities.user.User;
import org.realx.core.enums.common.UserType;
import org.realx.security.abstracts.DefaultSecurityJpaServiceImpl;
import org.realx.security.abstracts.SecurityJpaService;
import org.realx.security.entities.groups.DefaultSecurityGroup;
import org.realx.security.entities.groups.SecurityGroup;
import org.realx.security.entities.roles.SecurityRole;
import org.realx.security.repositories.DefaultSecurityGroupRepository;
import org.realx.security.repositories.SecurityGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class SecurityGroupService extends DefaultSecurityJpaServiceImpl<SecurityGroup, SecurityGroupRepository>
		implements SecurityJpaService<SecurityGroup> {
	@Autowired
	private SecurityGroupRepository securityGroupRepository;
	@Autowired
	private DefaultSecurityGroupRepository defaultSecurityGroupRepository;

	public DefaultSecurityGroupRepository getDefaultSecurityGroupRepository() {
		return defaultSecurityGroupRepository;
	}

	public void setDefaultSecurityGroupRepository(DefaultSecurityGroupRepository defaultSecurityGroupRepository) {
		this.defaultSecurityGroupRepository = defaultSecurityGroupRepository;
	}

	public SecurityGroupRepository getSecurityGroupRepository() {
		return securityGroupRepository;
	}

	public void setSecurityGroupRepository(SecurityGroupRepository securityGroupRepository) {
		this.securityGroupRepository = securityGroupRepository;
	}

	public List<GrantedAuthority> findGrantedAuthoritiesForUser(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<SecurityGroup> groups = getSecurityGroupRepository().findByUsersIn(user);
		for (SecurityGroup sg : groups) {
			for (SecurityRole sr : sg.getSecurityRoles()) {
				authorities.addAll(sr.getPermissions());
				authorities.add(sr);
			}

		}
		return authorities;
	}

	public void associateSecurityGroupToUsers(String userGroupName, Set<User> users) {
		List<SecurityGroup> securityGroups = getSecurityGroupRepository().findByGroupName(userGroupName);
		for (SecurityGroup sg : securityGroups) {
			sg.getUsers().addAll(users);
			getSecurityGroupRepository().save(sg);
		}
	}

	public void associateSecurityGroupToSingleUsers(String securityGroupName, User user) {
		Set<User> users = new HashSet<>();
		users.add(user);
		associateSecurityGroupToUsers(securityGroupName, users);
	}

	public Collection<SecurityGroup> getUserSecurityGroups(User user) {
		return getSecurityGroupRepository().findByUsersIn(user);
	}

	public List<SecurityGroup> findDefaultSecurityGroupsForUserType(UserType userType) {
		List<DefaultSecurityGroup> defaultSecurityGroups = getDefaultSecurityGroupRepository().findByUserType(userType);
		List<SecurityGroup> securityGroups = new ArrayList<>();
		for (DefaultSecurityGroup defaultSecurityGroup : defaultSecurityGroups) {
			securityGroups.add(defaultSecurityGroup.getSecurityGroup());
		}
		return securityGroups;
	}
}
