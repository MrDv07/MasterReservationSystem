package com.axis.UserService.exception;

public class ZeroException  extends RuntimeException{
	
	String message;

	public ZeroException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
