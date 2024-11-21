package com.universidad.crud.exceptions;

import com.universidad.crud.model.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<GenericResponse>
    handleUserNotFoundException(EntityNotFoundException ex, WebRequest request) {
        log.error("EntityNotFoundException:{}", ex.getMessage());
        GenericResponse errorDetails = new GenericResponse(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(),
        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GenericResponse>
    handleInvalidUserException(BadRequestException ex, WebRequest request) {
        log.error("BadRequestException:{}", ex.getMessage());
        GenericResponse errorDetails = new GenericResponse(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(),
        request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse> handleGlobalException(Exception ex, WebRequest request) {
        log.error("Exception: {}", ex.getMessage());
        GenericResponse errorDetails = new GenericResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }
