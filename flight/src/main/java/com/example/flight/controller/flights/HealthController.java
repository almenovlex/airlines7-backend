package com.example.flight.controller.flights;

import com.example.flight.entity.Health;
import com.example.flight.entity.HealthStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/flight", produces = APPLICATION_JSON_VALUE)
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<Health> getHealthStatus() {
        log.debug("REST request to get the Health Status");
        final Health health = new Health();
        health.setHealthStatus(HealthStatus.UP);
        return status(OK).body(health);
    }
}
