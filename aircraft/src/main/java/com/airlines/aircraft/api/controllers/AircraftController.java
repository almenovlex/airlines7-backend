package com.airlines.aircraft.api.controllers;

import com.airlines.aircraft.api.exceptions.BadRequestException;
import com.airlines.aircraft.enre.entities.Aircraft;
import com.airlines.aircraft.enre.service.AircraftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;
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

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createAircraftEntity(@RequestBody Aircraft aircraft) {
        service.createdAircraft(aircraft);
        return ok(OK);
    }

}
