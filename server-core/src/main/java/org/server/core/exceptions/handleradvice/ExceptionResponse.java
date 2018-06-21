package org.server.core.exceptions.handleradvice;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
public class ExceptionResponse {
	private String message;
//	private T entry;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExceptionResponse(String message) {
		this.message = message;
	}
//
//	public T getEntry() {
//		return entry;
//	}
//
//	public void setEntry(T entry) {
//		this.entry = entry;
//	}

	public ExceptionResponse() {

	}

	public ExceptionResponse message(String message) {
		this.message = message;
		return this;
	}

//	public ExceptionResponse entry(T entry) {
////		this.entry = entry;
//		return this;
//	}
}
