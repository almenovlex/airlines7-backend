package com.example.flight.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application")
public class FlightAppProperties {
    private String name;
    private String databaseUrl;
    private String adminEmail;
}
