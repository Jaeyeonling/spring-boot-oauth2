package com.jaeyeonling.boilerplate.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response<T> extends ResponseEntity<T> {
    
    public Response(final HttpStatus status) {
        super(status);
    }
}
