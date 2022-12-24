package com.aamir.rating.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException() {
        super("Resource not exist !!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
