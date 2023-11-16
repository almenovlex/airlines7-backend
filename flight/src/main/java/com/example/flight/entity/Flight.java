package com.example.flight.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * Класс для сущности "авиарейс"
 * @autor alexmenov
 * @version 1.0.0
 */
@Entity
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"flightId"})
@JsonPropertyOrder(alphabetic = true)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "flight", schema = "postgres_air")
public class Flight {
    /** Уникальный идентификатор рейса */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "flight_id")
    @JsonProperty("flightId")
    private Long flightId;

    /** Номер полета */
    @Column(name = "flight_no", nullable = false)
    @JsonProperty("flightNo")
    private String flightNo;

    /** Плановое время вылета */
    @Column(name = "scheduled_departure", nullable = false)
    @JsonProperty("scheduledDeparture")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp scheduledDeparture;

    /** Плановое время прибытия */
    @Column(name = "scheduled_arrival", nullable = false)
    @JsonProperty("scheduledArrival")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp scheduledArrival;

    /** Аэропорт вылета */
    @Column(name = "departure_airport", nullable = false)
    @JsonProperty("departureAirport")
    private String departureAirport;

    /** Аэропорт прилета */
    @Column(name = "arrival_airport", nullable = false)
    @JsonProperty("arrivalAirport")
    private String arrivalAirport;

    /** Статус рейса */
    @Column(nullable = false)
    @JsonProperty("status")
    private String status;

    /** Код аэропорта */
    @Column(name = "aircraft_code", nullable = false)
    @JsonProperty("aircraftCode")
    private String aircraftCode;

    /** Фактическое время вылета */
    @Column(name = "actual_departure")
    @JsonProperty("actualDeparture")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp actualDeparture;

    /** Фактическое время прилета */
    @Column(name = "actual_arrival")
    @JsonProperty("actualArrival")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp actualArrival;

    /** Автогенерируемая дата и время создания рейса */
    @Column(name = "created_at")
    @JsonIgnore
    @CreatedDate
    private Timestamp createdAt;

    /** Автогенерируемая дата и время обновления рейса */
    @Column(name = "update_ts")
    @JsonIgnore
    @LastModifiedDate
    private Timestamp updateTs;
}
