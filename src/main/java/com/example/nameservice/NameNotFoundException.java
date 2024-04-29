package com.example.nameservice;

public class NameNotFoundException extends RuntimeException {

    public NameNotFoundException(String message) {
        super(message);
    }
}
