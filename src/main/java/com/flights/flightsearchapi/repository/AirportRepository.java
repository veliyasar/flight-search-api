package com.flights.flightsearchapi.repository;

import com.flights.flightsearchapi.model.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends MongoRepository<Airport, String> {
}

