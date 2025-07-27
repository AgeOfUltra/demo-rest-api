package com.rest.api.services;

import com.rest.api.util.Flight;

import java.util.List;

public interface IRestService {
    void saveFlight(Flight flight);
    List<Flight> getAllFLights();
    Flight getFlightById(int id);
}
