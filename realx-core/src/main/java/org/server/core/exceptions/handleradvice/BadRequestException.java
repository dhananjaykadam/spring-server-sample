package org.server.core.exceptions.handleradvice;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BadRequestException(String reason) {
		super(reason);
	}
}
