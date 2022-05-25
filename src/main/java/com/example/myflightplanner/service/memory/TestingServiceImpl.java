package com.example.myflightplanner.service.memory;

import com.example.myflightplanner.repository.FlightsRepository;
import com.example.myflightplanner.service.TestingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "flight-planner", name = "store-type", havingValue = "in-memory")
public class TestingServiceImpl implements TestingService {

  private final FlightsRepository flightsRepository;

  public TestingServiceImpl(FlightsRepository flightsRepository) {
    this.flightsRepository = flightsRepository;
  }

  public void clear() {
    flightsRepository.clear();
  }
}
