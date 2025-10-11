package com.ecom.exception;

import org.springframework.web.bind.annotation.PathVariable;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) { super(message); }
}
