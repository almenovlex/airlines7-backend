package com.example.flight.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "flight", schema = "postgres_air")
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@JsonPropertyOrder(alphabetic = true)
public class Flight {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "flight_id")
    @JsonProperty("flightId")
    private Long flightId;

    @Column(name = "flight_no")
    @JsonProperty("flightNo")
    private String flightNo;

    @Column(name = "scheduled_departure")
    @JsonProperty("scheduledDeparture")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp scheduledDeparture;

    @Column(name = "scheduled_arrival")
    @JsonProperty("scheduledArrival")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp scheduledArrival;

    @Column(name = "departure_airport")
    @JsonProperty("departureAirport")
    private String departureAirport;

    @Column(name = "arrival_airport")
    @JsonProperty("arrivalAirport")
    private String arrivalAirport;

    @Column
    @JsonProperty("status")
    private String status;

    @Column(name = "aircraft_code")
    @JsonProperty("aircraftCode")
    private String aircraftCode;

    @Column(name = "actual_departure")
    @EqualsAndHashCode.Exclude
    @JsonProperty("actualDeparture")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp actualDeparture;

    @Column(name = "actual_arrival")
    @EqualsAndHashCode.Exclude
    @JsonProperty("actualArrival")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp actualArrival;

    @Column(name = "update_ts")
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Timestamp updateTs;
//
//    @Column(name = "flight_price")
//    private BigDecimal flightPrice;
}
