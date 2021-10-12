package com.sahil.cartService.exceptionhandlers;

import com.sahil.cartService.exceptions.CartNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CartControllerException {

    @ExceptionHandler(value = CartNotFoundException.class)
    public ResponseEntity handlerCartNotFoundException(){
        return new ResponseEntity("Cart id passed is empty/invalid", HttpStatus.BAD_REQUEST);
    }
}
