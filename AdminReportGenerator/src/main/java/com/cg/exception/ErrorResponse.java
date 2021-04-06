package com.cg.exception;

import java.time.LocalDateTime;

/**
 * 
 * @author Aditya Ghogale
 *
 */
public class ErrorResponse {
	private int status;

	
	private String message;
	private LocalDateTime errorTime;

	public ErrorResponse() {
		super();
		
	}
	
	public ErrorResponse(int status, String message, LocalDateTime errorTime) {
		super();
		this.status = status;
		this.message = message;
		
		this.errorTime = errorTime;
	}

	public LocalDateTime getErrorTime() {
		return errorTime.now();
	}

	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
