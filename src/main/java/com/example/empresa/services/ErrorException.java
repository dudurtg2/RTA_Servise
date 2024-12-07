package com.example.empresa.services;

public class ErrorException extends RuntimeException {

    private final int statusCode;

    public ErrorException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
