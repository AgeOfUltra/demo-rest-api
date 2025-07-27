package com.rest.api.exceptions;

public class FlightNotFoundException extends RuntimeException{
    public FlightNotFoundException(String message) {
        super(message);
    }
}
