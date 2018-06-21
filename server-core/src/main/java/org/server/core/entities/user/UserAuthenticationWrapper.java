package org.server.core.entities.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
public class UserAuthenticationWrapper extends WebAuthenticationDetails {
	private static final long serialVersionUID = 1L;
	private User user;

	public UserAuthenticationWrapper(HttpServletRequest request) {
		super(request);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
