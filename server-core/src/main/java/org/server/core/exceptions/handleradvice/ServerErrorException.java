package org.server.core.exceptions.handleradvice;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
public class ServerErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ServerErrorException(String message) {
		super(message);
	}
}
