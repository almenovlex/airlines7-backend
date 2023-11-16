package com.airlines.aircraft.enre.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aircraft", schema = "postgres_air")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
