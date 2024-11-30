package com.example.empresa.services;

public class CustomExceptionService extends RuntimeException {

    private final int statusCode;

    public CustomExceptionService(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
