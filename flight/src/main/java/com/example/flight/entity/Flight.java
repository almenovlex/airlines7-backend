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
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * Класс для сущности "авиарейс"
 * переопределены equals и hashcode (только по flightId)
 * json поля сортируются по алфавиту
 * добавлен аудит сущности через JPA
 *
 * @version 1.0.0
 * @autor alexmenov
 */
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"flightId"})
@JsonPropertyOrder(alphabetic = true)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "flight", schema = "postgres_air")
public class Flight implements Serializable {
    @Serial
    private static final long serialVersionUID = 10L;
    /**
     * Реализация оптимистичной блокировки в видео версионности
     */
    @Version
    public Long version;
    /**
     * Уникальный идентификатор рейса
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "flight_id")
    @JsonProperty("flightId")
    private Long flightId;
    /**
     * Номер полета
     */
    @Column(name = "flight_no", nullable = false)
    @JsonProperty("flightNo")
    private String flightNo;
    /**
     * Плановое время вылета
     */
    @Column(name = "scheduled_departure", nullable = false)
    @JsonProperty("scheduledDeparture")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime scheduledDeparture;
    /**
     * Плановое время прибытия
     */
    @Column(name = "scheduled_arrival", nullable = false)
    @JsonProperty("scheduledArrival")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime scheduledArrival;
    /**
     * Аэропорт вылета
     */
    @Column(name = "departure_airport", nullable = false)
    @JsonProperty("departureAirport")
    private String departureAirport;
    /**
     * Аэропорт прилета
     */
    @Column(name = "arrival_airport", nullable = false)
    @JsonProperty("arrivalAirport")
    private String arrivalAirport;
    /**
     * Статус рейса
     */
    @Column(nullable = false)
    @JsonProperty("status")
    private String status;
    /**
     * Код аэропорта
     */
    @Column(name = "aircraft_code", nullable = false)
    @JsonProperty("aircraftCode")
    private String aircraftCode;
    /**
     * Фактическое время вылета
     */
    @Column(name = "actual_departure")
    @JsonProperty("actualDeparture")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime actualDeparture;
    /**
     * Фактическое время прилета
     */
    @Column(name = "actual_arrival")
    @JsonProperty("actualArrival")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime actualArrival;
    /**
     * Автогенерируемая дата и время создания рейса
     */
    @Column(name = "created_at")
    @JsonIgnore
    @CreatedDate
    private OffsetDateTime createdAt;
    /**
     * Автогенерируемая дата и время обновления рейса
     */
    @Column(name = "update_ts")
    @JsonIgnore
    @LastModifiedDate
    private OffsetDateTime updateTs;
}
