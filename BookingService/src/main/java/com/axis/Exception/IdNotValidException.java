package com.axis.Exception;

public class IdNotValidException  extends RuntimeException{
	
	String message;

	public IdNotValidException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
