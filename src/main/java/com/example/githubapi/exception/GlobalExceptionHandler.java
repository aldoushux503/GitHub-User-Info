package com.example.githubapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(HttpClientErrorException ex) {
        ExceptionResponse exceptionResponse = createErrorResponse(404, "Non-existent Github user");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponse);
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ExceptionResponse> handleMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
        ExceptionResponse exceptionResponse = createErrorResponse(406, "Not acceptable media type");
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exceptionResponse);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handleMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
        ExceptionResponse exceptionResponse = createErrorResponse(400, "Invalid Accept header");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exceptionResponse);
    }

    private ExceptionResponse createErrorResponse(int status, String message) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setStatus(status);
        exceptionResponse.setMessage(message);
        return exceptionResponse;
    }
}

