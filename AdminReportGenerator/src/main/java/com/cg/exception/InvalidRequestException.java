package com.cg.exception;

/**
 * 
 * @author Aditya Ghogale
 *
 */
public class InvalidRequestException extends Exception {

	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InvalidRequestException(String message) {
		super();
		this.message = message;
	}

	public InvalidRequestException() {
		super();
	}
	
	
	
}
