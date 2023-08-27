package com.flights.flightsearchapi.service;

import com.flights.flightsearchapi.model.Airport;
import com.flights.flightsearchapi.model.Flight;
import com.flights.flightsearchapi.repository.AirportRepository;
import com.flights.flightsearchapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class ScheduledMockApiService {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    AirportRepository airportRepository;

    @Scheduled(cron = "0 0 0 * * ?") // Run at midnight (00:00:00) every day
    public void generateFlight() {
        Flight flight = new Flight();
        flight.setFlightId(UUID.randomUUID().toString().split("-")[0]);
        flight.setPrice(new Random().nextInt(900) + 100);
        flight.setDepartureAirport(getRandomAirport());
        flight.setArrivalAirport(getRandomAirport());
        flight.setDepartureTime(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        flightRepository.save(flight);
        System.out.println("Flight generated: " + flight.getFlightId());
    }

    public Airport getRandomAirport() {
        List<Airport> allAirports = airportRepository.findAll();
        int randomIndex = new Random().nextInt(allAirports.size());
        return allAirports.get(randomIndex);
    }
}
