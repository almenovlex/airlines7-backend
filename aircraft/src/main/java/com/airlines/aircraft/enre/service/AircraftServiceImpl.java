package com.airlines.aircraft.enre.service;

import com.airlines.aircraft.enre.entities.Aircraft;
import com.airlines.aircraft.enre.repositories.AircraftRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository repository;

    public AircraftServiceImpl(AircraftRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public Aircraft createdAircraft(Aircraft aircraft) {
        return repository.save(aircraft);
    }

    @Override
    public Optional<Aircraft> findAircraftByCode(String code) {
        return repository.findById(code);
    }

    @Override
    public Aircraft getByAirClass(int airClass) {
        return repository.findByClass(airClass);
    }

    @Override
    public List<Aircraft> findAllAircraft() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void updateAircraft(Aircraft aircraft) {
        repository.save(aircraft);
    }

    @Transactional
    @Override
    public void deleteAircraft(String code) {
        repository.deleteById(code);
    }
}
