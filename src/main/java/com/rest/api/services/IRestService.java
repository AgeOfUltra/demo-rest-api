package com.rest.api.services;

import com.rest.api.Flight;

import java.util.List;
import java.util.Optional;

public interface IRestService {
    void saveFlight(Flight flight);
    List<Flight> getAllFLights();
    Flight getFlightById(int id);
}
