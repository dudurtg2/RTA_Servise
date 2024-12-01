package com.example.empresa.services;

/**
 * Classe para representar exce es personalizadas.
 */
public class CustomExceptionService extends RuntimeException {

    private final int statusCode;

    public CustomExceptionService(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    /**
     * Retorna o status code HTTP associado a esta exce o.
     * 
     * @return status code HTTP
     */
    public int getStatusCode() {
        return statusCode;
    }
}
