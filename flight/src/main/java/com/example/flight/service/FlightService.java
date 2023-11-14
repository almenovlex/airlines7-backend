package com.example.flight.service;

import com.example.flight.entity.Flight;
import com.example.flight.repository.FlightRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public List<Flight> findFlightByDepartureAirportAndDepartureAndArrival (String departureAirport,
                                                                            String arrivalAirport,
                                                                            Date departure,
                                                                            Date arrival) {
        return flightRepository.findFlightByDepartureAirportAndScheduledDepartureAndScheduledArrival(
                departureAirport,
                arrivalAirport,
                departure,
                arrival);
    }

}
