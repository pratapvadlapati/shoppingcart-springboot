package com.shoppingcart.shoppingcart.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = ProductNotFound.class)
    // @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> exception(ProductNotFound e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Unauthorized.class)
    public ResponseEntity<Object> exception(Unauthorized e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);

    }

}
