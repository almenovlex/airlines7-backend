package com.example.flight.controller;

import com.example.flight.entity.Flight;
import com.example.flight.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "/api/flight", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping("/{departureAirport}&{departure}&{arrival}")
    public ResponseEntity<Flight> findFlightByDepartureAirportAndDepartureAndArrival(
            @PathVariable String departureAirport,
            @PathVariable String arrivalAirport,
            @PathVariable Date departure,
            @PathVariable Date arrival) {
        return status(OK).body(flightService.findFlightByDepartureAirportAndDepartureAndArrival(
                departureAirport,
                arrivalAirport,
                departure,
                arrival));
    }
}


