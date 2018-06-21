package org.server.core.exceptions.authentication;

import org.springframework.security.core.AuthenticationException;

public class AccountLockedException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountLockedException(String exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}

}
