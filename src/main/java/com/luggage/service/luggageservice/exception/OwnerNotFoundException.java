package com.luggage.service.luggageservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class OwnerNotFoundException  extends RuntimeException{
    
    public OwnerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OwnerNotFoundException(String s) {
    }
}
