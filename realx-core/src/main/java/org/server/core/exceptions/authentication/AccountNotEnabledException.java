package org.server.core.exceptions.authentication;

import org.springframework.security.core.AuthenticationException;

public class AccountNotEnabledException extends AuthenticationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotEnabledException(String exception) {
		super(exception);
	}
}
