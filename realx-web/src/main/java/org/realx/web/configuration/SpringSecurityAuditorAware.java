package org.realx.web.configuration;

import org.realx.core.entities.user.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

class SpringSecurityAuditorAware implements AuditorAware<User> {

	public User getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
		return (User) authentication.getPrincipal();
	}
}