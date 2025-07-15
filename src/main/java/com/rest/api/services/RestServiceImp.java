package com.rest.api.services;

import com.rest.api.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestServiceImp implements IRestService{
    List<Flight> flightList = new ArrayList<>();
    @Override
    public void saveFlight(Flight flight) {
        flightList.add(flight);
    }

    @Override
    public List<Flight> getAllFLights() {
        return flightList;
    }

    @Override
    public Flight getFlightById(int id) {
        return flightList.stream().filter(flight -> flight.getFlightId() == id).findFirst().orElse(null);
    }
}
