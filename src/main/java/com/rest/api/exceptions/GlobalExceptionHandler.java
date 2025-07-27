package com.rest.api.exceptions;

import com.rest.api.util.FlightErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(FlightNotFoundException e){

        FlightErrorResponse response = new FlightErrorResponse(LocalDateTime.now(),e.getMessage(),"Flight not found");
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
}
