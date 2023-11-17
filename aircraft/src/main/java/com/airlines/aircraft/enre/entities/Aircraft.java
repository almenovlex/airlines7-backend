package com.airlines.aircraft.enre.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "aircraft", schema = "postgres_air")
public class Aircraft {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "model")
    private String model;

    @Column(name = "range")
    private int range;

    @Column(name = "class")
    private int aircraftClass;

    @Column(name = "velocity")
    private int velocity;
}
