package org.realx.core.exceptions.authentication;

import org.springframework.security.core.AuthenticationException;

public class BadCredentialsException extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadCredentialsException(String msg) {
		super(msg);
	}

}
