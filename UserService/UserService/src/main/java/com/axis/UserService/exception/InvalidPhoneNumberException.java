package com.axis.UserService.exception;

public class InvalidPhoneNumberException extends RuntimeException{
	
	String message;

	public InvalidPhoneNumberException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
