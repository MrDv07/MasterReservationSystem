package com.axis.exception;

public class IdNotValidException extends RuntimeException {
	
	String message;

	public IdNotValidException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
