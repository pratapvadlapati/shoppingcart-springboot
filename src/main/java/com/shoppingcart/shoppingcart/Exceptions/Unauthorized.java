package com.shoppingcart.shoppingcart.Exceptions;

public class Unauthorized extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public Unauthorized() {
        super();
    }

    public Unauthorized(String message) {
        super(message);
    }

}
