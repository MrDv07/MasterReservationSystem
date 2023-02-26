package com.axis.Exception;

public class ZeroException extends RuntimeException {

    String message;

    public ZeroException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
