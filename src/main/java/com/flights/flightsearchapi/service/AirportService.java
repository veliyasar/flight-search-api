package com.flights.flightsearchapi.service;

import com.flights.flightsearchapi.model.Airport;
import com.flights.flightsearchapi.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport addAirport(Airport airport) {
        // take the first part of UUID for simplicity
        airport.setAirportId(UUID.randomUUID().toString().split("-")[0]);
        return airportRepository.save(airport);
    }

    public Airport getAirportById(String airportId) {
        return airportRepository.findById(airportId).get();
    }

    public String deleteAirportById(String airportId) {
        airportRepository.deleteById(airportId);
        return airportId + " airport deleted.";
    }

    public Airport updateAirport(Airport airportRequest) {
        // populate new value from request to existing entity/document
        Airport existingAirport = airportRepository.findById(airportRequest.getAirportId()).get();
        existingAirport.setCity(airportRequest.getCity());
        return airportRepository.save(existingAirport);
    }
}
