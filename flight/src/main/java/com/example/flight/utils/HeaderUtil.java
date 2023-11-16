package com.example.flight.utils;

import com.example.flight.config.FlightAppProperties;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class HeaderUtil {
    private final FlightAppProperties properties;
    private HttpHeaders headers;

    @PostConstruct
    private void setAppProperties() {
        headers = new HttpHeaders();
        headers.set("Module-name", properties.getName());
        headers.set("Admin-email-to-contact", properties.getAdminEmail());
    }
}
