package com.flights.flightsearchapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    private String flightId;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private String departureTime; // dd-MM-yyyy
    private String returnTime; // dd-MM-yyyy
    private Integer price;
}
