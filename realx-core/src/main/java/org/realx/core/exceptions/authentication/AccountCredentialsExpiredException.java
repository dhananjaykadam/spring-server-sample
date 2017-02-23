package org.realx.core.exceptions.authentication;

import org.springframework.security.core.AuthenticationException;

public class AccountCredentialsExpiredException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountCredentialsExpiredException(String exception) {
		super(exception);
	}
}
