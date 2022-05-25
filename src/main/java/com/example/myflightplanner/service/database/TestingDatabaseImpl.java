package com.example.myflightplanner.service.database;

import com.example.myflightplanner.repository.AirportDatabaseRepository;
import com.example.myflightplanner.repository.FlightDatabaseRepository;
import com.example.myflightplanner.service.TestingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "flight-planner", name = "store-type", havingValue = "database")
public class TestingDatabaseImpl implements TestingService {

  private final FlightDatabaseRepository flightDatabaseRepository;
  private final AirportDatabaseRepository airportDatabaseRepository;

  public TestingDatabaseImpl(FlightDatabaseRepository flightDatabaseRepository, AirportDatabaseRepository airportDatabaseRepository) {
    this.flightDatabaseRepository = flightDatabaseRepository;
    this.airportDatabaseRepository = airportDatabaseRepository;
  }

  @Override
  public void clear() {
    flightDatabaseRepository.deleteAll();
    airportDatabaseRepository.deleteAll();
  }
}
