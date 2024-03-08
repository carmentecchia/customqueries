package com.example.custom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query(value = "SELECT DESCRIPTION FROM FLIGHT", nativeQuery = true)
    List<String> retrieveAllFlights();
}
