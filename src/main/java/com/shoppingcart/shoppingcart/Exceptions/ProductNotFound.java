package com.shoppingcart.shoppingcart.Exceptions;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product not found to update")
public class ProductNotFound extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProductNotFound() {
        super();
    }

    public ProductNotFound(String message) {

        super(message);
    }

}
