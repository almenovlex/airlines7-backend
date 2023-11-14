package com.example.flight.repository;

import com.example.flight.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("select f " +
            "from Flight f " +
            "where f.departureAirport = :departureAirport " +
            "and f.arrivalAirport = :arrivalAirport " +
            "and cast(f.scheduledDeparture as timestamp) = :scheduledDeparture " +
            "and cast(f.scheduledArrival as timestamp) = :scheduledArrival")
    List<Flight> findFlightByDepartureAirportAndScheduledDepartureAndScheduledArrival(
            String departureAirport, String arrivalAirport, Date scheduledDeparture, Date scheduledArrival);
}
