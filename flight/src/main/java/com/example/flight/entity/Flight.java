package com.example.flight.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "flight", schema = "air")
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode
public class Flight {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "flight_id")
    private final Long flightIdl;

    @Column(name = "flight_no")
    private final String flightNo;

    @Column(name = "scheduled_departure")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private final Timestamp scheduledDeparture;

    @Column(name = "scheduled_arrival")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private final Timestamp scheduledArrival;

    @Column(name = "departure_airport")
    private final String departureAirport;

    @Column(name = "arrival_airport")
    private final String arrivalAirport;

    @Column
    private final String status;

    @Column(name = "aircraft_code")
    private final String aircraftCode;

    @Column(name = "actual_departure")
    @EqualsAndHashCode.Exclude
    private final Timestamp actualDeparture;

    @Column(name = "actual_arrival")
    @EqualsAndHashCode.Exclude
    private final Timestamp actualArrival;

    @Column(name = "update_ts")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private final Timestamp updateTs;

    @Column(name = "flight_price")
    private final BigDecimal flightPrice;
}
