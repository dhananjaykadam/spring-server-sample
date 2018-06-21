package org.server.core.exceptions.handleradvice;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
public class NoPermissionException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoPermissionException(String message) {
		super(message);
	}

}
