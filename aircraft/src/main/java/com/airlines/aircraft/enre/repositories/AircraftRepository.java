package com.airlines.aircraft.enre.repositories;

import com.airlines.aircraft.enre.entities.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, String> {

    @Query("SELECT DISTINCT a FROM Aircraft a WHERE a.aircraftClass = :airClass")
    Aircraft findByClass(@Param("airClass") int airClass);

}
