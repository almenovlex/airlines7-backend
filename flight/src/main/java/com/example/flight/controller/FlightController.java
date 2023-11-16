package com.example.flight.controller;

import com.example.flight.entity.Flight;
import com.example.flight.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "/api/flight", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping("/{departureAirport}&{arrivalAirport}")
    public ResponseEntity<List<Flight>> findFlightByDepartureAirportAndDepartureAndArrival(
            @PathVariable String departureAirport,
            @PathVariable String arrivalAirport) {
        return status(OK).body(flightService.findFlightByDepartureAirportAndDepartureAndArrival(
                departureAirport,
                arrivalAirport));
    }
}


