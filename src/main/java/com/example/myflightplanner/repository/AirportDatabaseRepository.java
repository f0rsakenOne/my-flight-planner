package com.example.myflightplanner.repository;

import com.example.myflightplanner.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportDatabaseRepository extends JpaRepository<Airport, String> {

}
