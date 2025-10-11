package com.ecom.exception;

public class CartItemNotFoundException extends RuntimeException {
    public CartItemNotFoundException(String messageString) {
        super(messageString);
    }
}
