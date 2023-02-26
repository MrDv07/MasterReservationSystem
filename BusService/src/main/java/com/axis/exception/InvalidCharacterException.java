package com.axis.exception;

public class InvalidCharacterException extends RuntimeException{
	
	
	String message;

    public InvalidCharacterException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
