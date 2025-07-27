package com.rest.api.controllers;

import com.rest.api.exceptions.FlightNotFoundException;
import com.rest.api.util.Flight;
import com.rest.api.services.RestServiceImp;
import com.rest.api.util.FlightErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class FlightController {
    @Autowired
    RestServiceImp service;

    @GetMapping("/flights/all")
    public ResponseEntity<List<Flight>> getAllFLights() {
        List<Flight> flights = service.getAllFLights();
        return ResponseEntity.ok().body(flights);
    }

    @PostMapping("flights/add")
    public ResponseEntity<Void> saveFlight(@RequestBody Flight flight) {
        service.saveFlight(flight);
        return ResponseEntity.status(201).build();
    }
//   Traditional way of handling exceptions by using try catch block.
//    @GetMapping("/flightByID/{id}")
//    ResponseEntity<?> getFlightById(@PathVariable int id) {
//        try{
//            Flight flight = service.getAllFLights().stream().filter(a -> a.getFlightId()==id)
//                    .findFirst()
//                    .orElseThrow(() -> new FlightNotFoundException("FLight not found with id"+id));
//            return ResponseEntity.ok().body(flight);
//        }catch(FlightNotFoundException e){
//            FlightErrorResponse flightErrorResponse = new FlightErrorResponse(LocalDateTime.now(),e.getMessage(),"Flight not found");
//            return new ResponseEntity<>(flightErrorResponse,HttpStatus.NOT_FOUND);
//        }
//
//    }

    @GetMapping("/flightByID/{id}")
    ResponseEntity<Flight> getFlightById(@PathVariable int id) {
            Flight flight = service.getAllFLights().stream().filter(a -> a.getFlightId()==id)
                    .findFirst()
                    .orElseThrow(() -> new FlightNotFoundException("FLight not found with id"+id));
            return ResponseEntity.ok().body(flight);
    }

    @GetMapping("/flightByName/{name}")
    public ResponseEntity<Flight> getFlightByName(@PathVariable String name){
        Flight flight = service.getAllFLights().stream().filter(a -> a.getFlightName().equals(name))
                .findFirst()
                .orElseThrow(() -> new FlightNotFoundException("FLight not found with name "+name));
        return ResponseEntity.ok().body(flight);
    }


//    second way of handling the Exception
//    @ExceptionHandler(FlightNotFoundException.class)
//    public ResponseEntity<?> handleProductNotFoundException(FlightNotFoundException e){
//
//        FlightErrorResponse response = new FlightErrorResponse(LocalDateTime.now(),e.getMessage(),"Flight not found");
//        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
//
//    }
}
