package com.example.myflightplanner.service;

import com.example.myflightplanner.repository.FlightsRepository;
import org.springframework.stereotype.Service;

@Service
public class TestingService {

  private final FlightsRepository flightsRepository;

  public TestingService(FlightsRepository flightsRepository) {
    this.flightsRepository = flightsRepository;
  }

  public void clear() {
    flightsRepository.clear();
  }
}
