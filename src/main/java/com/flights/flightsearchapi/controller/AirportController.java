package com.flights.flightsearchapi.controller;

import com.flights.flightsearchapi.model.Airport;
import com.flights.flightsearchapi.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{airportId}")
    public Airport getAirport(@PathVariable String airportId) {
        return airportService.getAirportById(airportId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.addAirport(airport);
    }

    @DeleteMapping("/{airportId}")
    public String deleteAirport(@PathVariable String airportId) {
        return airportService.deleteAirportById(airportId);
    }

    @PutMapping
    public Airport modifyAirport(@RequestBody Airport airport){
        return airportService.updateAirport(airport);
    }
}
