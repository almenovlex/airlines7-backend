package com.example.flight.service;

import com.example.flight.entity.Flight;
import com.example.flight.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public List<Flight> findFlightByDepartureAirportAndDepartureAndArrival(String departureAirport,
                                                                            String arrivalAirport) {
        List<Flight> flights = flightRepository.findFlightsByDepartureAirportAndArrivalAirport(
                departureAirport,
                arrivalAirport);
        log.info("flights: {}", flights);
        return flights;
    }


}
