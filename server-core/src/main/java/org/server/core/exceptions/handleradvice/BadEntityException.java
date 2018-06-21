package org.server.core.exceptions.handleradvice;

public class BadEntityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadEntityException(String exception) {
		super(exception);
	}
}
