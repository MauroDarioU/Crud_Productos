package com.universidad.crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class GlobalExceptionProducto {
    // excepciones cuando un producto no se encuentra
    @ExceptionHandler(EntityNotFoundExceptions.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // 404 NOT FOUND
    public ResponseEntity<String> handleResourceNotFound(EntityNotFoundExceptions ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND); // Error 404
    }

    // Excepciones generales
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Error 500
     public ResponseEntity<String> handleAllExceptions(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // Error 500


}
