package com.example.flight.repository;

import com.example.flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {

    @Query(value = "SELECT * FROM airlines.postgres_air.flight WHERE departure_airport = :departureAirport AND arrival_airport = :arrivalAirport AND scheduled_departure = :scheduledDepartureDate", nativeQuery = true)
    List<Flight> findFlightsByAirportsAndDepartureDate(
            String departureAirport,
            String arrivalAirport,
            String scheduledDepartureDate);
}
