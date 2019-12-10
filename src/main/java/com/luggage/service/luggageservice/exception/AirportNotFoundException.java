package com.luggage.service.luggageservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AirportNotFoundException extends RuntimeException {

    public AirportNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AirportNotFoundException() {

    }

    public AirportNotFoundException(String message) {
    }

   // public AirportNotFoundException(String message, String no_city_found) {
    //}
}

