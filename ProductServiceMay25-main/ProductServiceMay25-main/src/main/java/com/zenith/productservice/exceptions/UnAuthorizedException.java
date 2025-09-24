package com.zenith.productservice.exceptions;

public class UnAuthorizedException extends RuntimeException {
    private String message;

    public UnAuthorizedException(String message) {
        super(message);
    }
}
