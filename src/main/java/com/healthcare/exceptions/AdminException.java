package com.healthcare.exceptions;

public class AdminException extends RuntimeException{
		
	private String message;
	public AdminException() {
		
	}
	public AdminException(String message) {
		super();
		this.message = message;
	}
 
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}
 
	@Override
	public String toString() {
		return "UserException message=" + message;
	}

	}
