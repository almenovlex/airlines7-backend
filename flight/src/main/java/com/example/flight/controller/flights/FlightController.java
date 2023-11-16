package com.example.flight.controller.flights;

import com.example.flight.entity.Flight;
import com.example.flight.service.FlightService;
import com.example.flight.utils.HeaderUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "/api/flight", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FlightController {
    private final HeaderUtil headerUtil;
    private final FlightService flightService;

    @GetMapping("/departure={departureAirport}&arrival={arrivalAirport}")
    public ResponseEntity<List<Flight>> findFlightsByDepartureAirportAndDepartureAndArrival(
            @PathVariable String departureAirport,
            @PathVariable String arrivalAirport) {
        return status(OK)
                .headers(headerUtil.getHeaders())
                .body(flightService.findFlightByDepartureAirportAndDepartureAndArrival(
                        departureAirport,
                        arrivalAirport));
    }

    @GetMapping("/flight_id={flightId}")
    public ResponseEntity<Flight> findFlightById(@PathVariable long flightId) {
        return status(OK)
                .headers(headerUtil.getHeaders())
                .body(flightService.findFlightByFlightId(flightId));
    }

    @GetMapping("/page={page}&{limit}")
    public List<Flight> findFlightsByPageWithLimit(@PathVariable int page, @PathVariable int limit) {
        return flightService.findAllFlights(page, limit);
    }
}


