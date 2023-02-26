package com.axis.TrainService.Exception;

public class InvalidCharacterException extends RuntimeException {
    String message;

    public InvalidCharacterException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
