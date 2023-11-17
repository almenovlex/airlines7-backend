package com.example.flight.service;

import com.example.flight.entity.Flight;
import com.example.flight.exception.ResourceNotFoundException;
import com.example.flight.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Класс-сервис для работы с сущностью Flight
 *
 * @version 1.0.0
 * @autor alexmenov
 */
@Service
@Transactional
@RequiredArgsConstructor
public class FlightService {

    /**
     * Поле класса-репозитория для доступа к базе данных
     */
    private final FlightRepository flightRepository;

    /**
     * Осуществляет поиск авиарейсов по параметрам
     *
     * @param departureAirport - аэропорт вылета
     * @param arrivalAirport   - аэропорт прибытия
     * @return список авиарейсов из точки А в точку В в указанном диапозоне дат либо "пустой" List
     */
    public List<Flight> findFlightByDepartureAirportAndDepartureAndArrival(String departureAirport,
                                                                           String arrivalAirport,
                                                                           String scheduledDeparture) {
        return flightRepository.findFlightsByAirportsAndDepartureDate(
                departureAirport,
                arrivalAirport,
                scheduledDeparture);
    }

    /**
     * Осуществляет поиск авиареса по его id
     *
     * @param flightId - id авиарейса
     * @return авиарейс
     * @throws ResourceNotFoundException в случае отсутствия авиарейса
     */
    public Flight findFlightByFlightId(Long flightId) {
        return flightRepository
                .findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight with id " + flightId + " not found."));
    }

    /**
     * Пагинация авиарейсов
     *
     * @param page  - страница (начало отчета или offset), по умолчанию 0
     * @param limit - количество авиарейсов, по умолчанию 20
     * @return список авиарейсов
     */
    public List<Flight> findFlightsByPageWithLimit(int page, int limit) {
        return flightRepository
                .findAll(PageRequest.of(Math.max(page, 0), Math.min(limit, 20)))
                .toList();
    }

}
