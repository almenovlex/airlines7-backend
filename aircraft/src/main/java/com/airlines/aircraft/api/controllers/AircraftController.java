package com.airlines.aircraft.api.controllers;

import com.airlines.aircraft.enre.entities.Aircraft;
import com.airlines.aircraft.enre.service.AircraftService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "/api/aircraft", produces = APPLICATION_JSON_VALUE)
public class AircraftController {

    private final AircraftService service;

    public AircraftController(AircraftService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Aircraft>> findAllAircraft() {
        return status(OK).body(service.findAllAircraft());
    }

    @PostMapping
    public ResponseEntity<Aircraft> createAircraftEntity(@RequestBody Aircraft aircraft) {
        return status(CREATED).body(service.createdAircraft(aircraft));
    }

}
