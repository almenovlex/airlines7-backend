package com.example.flight.controller.flights;

import com.example.flight.entity.Flight;
import com.example.flight.service.FlightService;
import com.example.flight.utils.HeaderUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/flight", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FlightController {
    private final HeaderUtil headerUtil;
    private final FlightService flightService;

    @GetMapping("/departure={departureAirport}&arrival={arrivalAirport}&{scheduledDeparture}")
    public ResponseEntity<List<Flight>> findFlightsByDepartureAirportAndDepartureAndArrival(
            @PathVariable final String departureAirport,
            @PathVariable final String arrivalAirport,
            @PathVariable final String scheduledDeparture
    ) {
        log.debug("REST request to get flights : {}", "from "
                + departureAirport
                + " to "
                + arrivalAirport
                + ", dates: "
                + scheduledDeparture);
        return status(OK)
                .headers(headerUtil.getHeaders())
                .body(flightService.findFlightByDepartureAirportAndDepartureAndArrival(
                        departureAirport,
                        arrivalAirport,
                        scheduledDeparture
                ));
    }

    @GetMapping("/flight_id={flightId}")
    public ResponseEntity<Flight> findFlightById(@PathVariable final long flightId) {
        return status(OK)
                .headers(headerUtil.getHeaders())
                .body(flightService.findFlightByFlightId(flightId));
    }

    @GetMapping("/page={page}&{limit}")
    public ResponseEntity<List<Flight>> findFlightsByPageWithLimit(
            @PathVariable final int page,
            @PathVariable final int limit) {
        return status(OK)
                .headers(headerUtil.getHeaders())
                .body(flightService.findFlightsByPageWithLimit(page, limit));
    }

    @PostMapping
    public void findFlightsByPageWithLimit(@RequestBody final Flight flight) {
        log.warn("flight: {}", flight);
    }
}


