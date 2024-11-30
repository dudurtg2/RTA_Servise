package com.example.empresa.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * Lida com exce es customizadas do tipo {@link CustomExceptionService}.
     * 
     * @param ex exce o customizada
     * @return uma resposta HTTP com o status e a mensagem da exce o
     */
    @ExceptionHandler(CustomExceptionService.class)
    public ResponseEntity<?> handleCustomException(CustomExceptionService ex) {
        
        return ResponseEntity
                .status(ex.getStatusCode())
                .body(new ErrorResponse(ex.getMessage(), ex.getStatusCode()));
    }


    
    /**
     * Lida com exce es gen ricas, retornando uma resposta HTTP
     * com status 500 (Internal Server Error) e uma mensagem gen rica
     * de erro.
     * 
     * @param ex exce o gen rica
     * @return uma resposta HTTP com o status 500 e uma mensagem de erro
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Ocorreu um erro inesperado", HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    
    static class ErrorResponse {
        private String message;
        private int status;

        public ErrorResponse(String message, int status) {
            this.message = message;
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public int getStatus() {
            return status;
        }
    }
}
