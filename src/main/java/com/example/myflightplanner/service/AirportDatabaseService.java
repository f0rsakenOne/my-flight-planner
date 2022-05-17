package com.example.myflightplanner.service;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.repository.AirportDatabaseRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportDatabaseService {
  private final AirportDatabaseRepository airportDatabaseRepository;

  public AirportDatabaseService(AirportDatabaseRepository airportDatabaseRepository) {
    this.airportDatabaseRepository = airportDatabaseRepository;
  }

  public void addAirport(Airport airport) {
    airportDatabaseRepository.save(airport);
  }
}
