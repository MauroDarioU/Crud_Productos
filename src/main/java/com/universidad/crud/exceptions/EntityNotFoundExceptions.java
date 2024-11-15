package com.universidad.crud.exceptions;

public class EntityNotFoundExceptions extends RuntimeException {
    public EntityNotFoundExceptions(String message) {
        super(message);
    }

}