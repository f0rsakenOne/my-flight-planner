package com.example.myflightplanner.controllers;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.service.AirportDatabaseService;
import com.example.myflightplanner.service.TestingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing-api")
public class TestingController {

  private final TestingService testingService;
  private final AirportDatabaseService airportDatabaseService;

  public TestingController(TestingService testingService, AirportDatabaseService airportDatabaseService) {
    this.testingService = testingService;
    this.airportDatabaseService = airportDatabaseService;
  }

  @PostMapping("/clear")
  public void clear() {
    testingService.clear();
  }

  @GetMapping("/add-test-flight")
  public void addTestFlight() {
    airportDatabaseService.addAirport(new Airport("Latvia", "Riga", "Rix"));
  }
}
