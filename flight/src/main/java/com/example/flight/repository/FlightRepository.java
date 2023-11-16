package com.example.flight.repository;

import com.example.flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {

    @Query("SELECT f "
            + "FROM Flight f "
            + "WHERE f.departureAirport = :departureAirport "
            + "AND f.arrivalAirport = :arrivalAirport ")
    List<Flight> findFlightsByDepartureAirportAndArrivalAirport(
            String departureAirport, String arrivalAirport);
}
