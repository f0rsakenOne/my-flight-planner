package com.example.myflightplanner.service.database;

import com.example.myflightplanner.repository.FlightDatabaseRepository;
import com.example.myflightplanner.service.TestingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "flight-planner", name = "store-type", havingValue = "database")
public class TestingDatabaseImpl implements TestingService {

  private final FlightDatabaseRepository flightDatabaseRepository;

  public TestingDatabaseImpl(FlightDatabaseRepository flightDatabaseRepository) {
    this.flightDatabaseRepository = flightDatabaseRepository;
  }

  @Override
  public void clear() {
    flightDatabaseRepository.deleteAll();
  }
}
