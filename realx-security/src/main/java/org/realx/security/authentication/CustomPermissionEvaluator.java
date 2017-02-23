package org.realx.security.authentication;

import java.io.Serializable;

import org.realx.core.entities.user.User;
import org.realx.security.entities.permissions.SecurityPermission;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component("CustomPermissionEvaluator")
public class CustomPermissionEvaluator implements PermissionEvaluator {
	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		if (authentication != null && targetDomainObject instanceof Authentication && permission instanceof String) {
			for (GrantedAuthority g : ((Authentication) targetDomainObject).getAuthorities()) {
				if (g instanceof SecurityPermission && g.getAuthority().equals(permission)) {
					return true;
				}
			}
		} else if (authentication != null && targetDomainObject instanceof User && permission instanceof String) {
			for (GrantedAuthority g : ((User) targetDomainObject).getAuthorities()) {
				if (g instanceof SecurityPermission && g.getAuthority().equals(permission)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		return false;
	}

	/**
	 * '@PreAuthorize("@CustomPermissionEvaluator.hasSecurityGroup(authentication,#username)")'
	 * 
	 * @param authentication
	 * @param targetDomainObject
	 * @return
	 */
	public boolean hasSecurityGroup(Authentication authentication, Object targetDomainObject) {
		return false;
	}

	public boolean hasSpaceWAccess(Authentication authentication, String username, String spaceId) {
		return false;
	}
}
