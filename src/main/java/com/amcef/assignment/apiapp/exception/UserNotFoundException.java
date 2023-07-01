package com.amcef.assignment.apiapp.exception;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}

