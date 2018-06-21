package org.server.core.exceptions.authentication;

import org.springframework.security.core.AuthenticationException;

public class AccountExpiredException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountExpiredException(String exception) {
		super(exception);
	}
}
