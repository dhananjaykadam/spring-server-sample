package org.server.security.accessmanager;

import java.util.List;

import org.server.core.entities.user.User;
import org.server.security.entities.groups.SecurityGroup;
import org.server.security.entities.permissions.SecurityPermission;
import org.server.security.entities.roles.SecurityRole;
import org.springframework.stereotype.Component;

@Component
public class AccessManager {

	public List<SecurityPermission> getUserPermissions(User user) {
		return null;
	}

	public List<SecurityRole> getUserRoles(User user) {
		return null;
	}

	public List<SecurityGroup> getUserSecurityGroups(User user) {
		return null;
	}

	public Boolean hasRole(User user, String role) {
		if (user != null && user.getAuthorities() != null) {
			return user.getAuthorities().stream().anyMatch((r) -> r.getAuthority().equals(role));
		}
		return false;
	}

	public Boolean hasPermission(User user, String role) {
		return hasRole(user, role);
	}
}
