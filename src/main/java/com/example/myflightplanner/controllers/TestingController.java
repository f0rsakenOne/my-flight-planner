package com.example.myflightplanner.controllers;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.request.AddFlightRequest;
import com.example.myflightplanner.service.database.AdminDatabaseImpl;
import com.example.myflightplanner.service.AirportDatabaseService;
import com.example.myflightplanner.service.TestingService;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing-api")
public class TestingController {

  private final TestingService testingService;
  private final AirportDatabaseService airportDatabaseService;
  private final AdminDatabaseImpl adminDatabase;

  public TestingController(TestingService testingService, AirportDatabaseService airportDatabaseService, AdminDatabaseImpl adminDatabase) {
    this.testingService = testingService;
    this.airportDatabaseService = airportDatabaseService;
    this.adminDatabase = adminDatabase;
  }

  @PostMapping("/clear")
  public void clear() {
    testingService.clear();
  }

  @GetMapping("/add-test-airport")
  public void addTestFlight() {
    airportDatabaseService.addAirport(new Airport("Latvia", "Riga", "RIX"));
  }

  @Transactional
  @PutMapping("/add-test-flights")
  public Flight addFlight() {
    Airport airport_from = new Airport("Latvia", "Riga", "RIX");
    Airport airport_to = new Airport("Japan","Tokyo","JPN");
    AddFlightRequest addFlightRequest = new AddFlightRequest(airport_from,airport_to,"DICK",
        "2022-05-18 20:00","2022-05-18 22:00");
    Flight flight = addFlightRequest.toDomain();
    adminDatabase.addFlight(flight);
    return flight;
  }
}
