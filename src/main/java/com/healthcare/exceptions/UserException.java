package com.healthcare.exceptions;

public class UserException extends RuntimeException{

	private String message;
	public UserException() {
		
	}
	public UserException(String message) {
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
