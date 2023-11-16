package com.airlines.aircraft.enre.service;

import com.airlines.aircraft.enre.entities.Aircraft;

import java.util.List;
import java.util.Optional;

public interface AircraftService {

    void createdAircraft(Aircraft aircraft);

    Optional<Aircraft> findAircraftByCode(String code);

    Aircraft getByAirClass(int airClass);

    List<Aircraft> findAllAircraft();

    void updateAircraft(Aircraft aircraft);

    void deleteAircraft(String code);
}
