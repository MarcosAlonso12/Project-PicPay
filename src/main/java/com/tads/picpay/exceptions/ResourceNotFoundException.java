package com.tads.picpay.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String ex) {
        super(ex);
    }
}
