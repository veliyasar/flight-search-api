package com.flights.flightsearchapi.controller;

import com.flights.flightsearchapi.model.Flight;
import com.flights.flightsearchapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{flightId}")
    public Flight getAirport(@PathVariable String flightId) {
        return flightService.getFlightById(flightId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @DeleteMapping("/{flightId}")
    public String deleteFlight(@PathVariable String flightId) {
        return flightService.deleteFlightById(flightId);
    }

    @PutMapping
    public Flight modifyFlight(@RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }

    @GetMapping("/search")
    public List<Flight> findFlights(
            // request can't be sent with a (JSON) body
            @RequestParam(name = "departureAirport") String departureAirport,
            @RequestParam(name = "arrivalAirport") String arrivalAirport,
            @RequestParam(name = "departureTime") String departureTime,
            @RequestParam(name = "returnTime", required = false) String returnTime
    ) {
        return flightService.searchFlights(departureAirport, arrivalAirport, departureTime, returnTime);
    }

    @GetMapping("/searchWithDates")
    public List<Flight> findFlightsWithDates(
            @RequestParam(name = "startDate") String startDateStr,
            @RequestParam(name = "endDate") String endDateStr
    ) {
        return flightService.searchFlightsBetweenDates(startDateStr, endDateStr);
    }
}
