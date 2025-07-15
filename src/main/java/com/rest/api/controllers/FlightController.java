package com.rest.api.controllers;

import com.rest.api.Flight;
import com.rest.api.services.RestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("flights/flight/{id}")
    ResponseEntity<Flight> getFlightById(@PathVariable int id) {
        return ResponseEntity.ok().body(service.getFlightById(id));
    }

}
