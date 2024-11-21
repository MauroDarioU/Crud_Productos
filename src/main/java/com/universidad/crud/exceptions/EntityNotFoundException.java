package com.universidad.crud.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)

public class EntityNotFoundException extends ApiException {
    public EntityNotFoundException(String code, String message) {
        super(HttpStatus.NOT_FOUND, code, message);
    }

}