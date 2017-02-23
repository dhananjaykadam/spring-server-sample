package org.realx.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.realx.core.entities.user.User;
import org.realx.core.enums.common.UserType;
import org.realx.security.entities.groups.SecurityGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class SecurityManagerService {
	@Autowired
	private SecurityGroupService securityGroupService;

	public SecurityGroupService getSecurityGroupService() {
		return securityGroupService;
	}

	public List<GrantedAuthority> findGrantedAuthoritiesForUser(User user) {
		return getSecurityGroupService().findGrantedAuthoritiesForUser(user);
	}

	public void associateSecurityGroupToUsers(String userGroupName, Set<User> users) {
		getSecurityGroupService().associateSecurityGroupToUsers(userGroupName, users);
	}

	public void associateSecurityGroupToSingleUsers(String securityGroupName, User user) {
		getSecurityGroupService().associateSecurityGroupToSingleUsers(securityGroupName, user);
	}

	public Collection<SecurityGroup> getUserSecurityGroups(User user) {
		return getSecurityGroupService().getUserSecurityGroups(user);
	}

	public List<SecurityGroup> findDefaultSecurityGroupsForUserType(UserType userType) {
		return getSecurityGroupService().findDefaultSecurityGroupsForUserType(userType);
	}

	public void associateDefaultSecurityGroupToUsersByUserType(UserType userType, User user) {
		List<SecurityGroup> securityGroups = getSecurityGroupService().findDefaultSecurityGroupsForUserType(userType);
		for (SecurityGroup securityGroup : securityGroups) {
			associateSecurityGroupToSingleUsers(securityGroup.getGroupName(), user);
		}
	}
}
