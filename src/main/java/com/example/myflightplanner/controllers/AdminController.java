package com.example.myflightplanner.controllers;

import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.service.FlightPlannerService;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin-api")
public class AdminController {

  private final FlightPlannerService flightPlannerService;

  public AdminController(FlightPlannerService flightPlannerService) {
    this.flightPlannerService = flightPlannerService;
  }

  @PutMapping("flights")
  public ResponseEntity<Flight> addFlight(@Valid @RequestBody Flight flight) {
    return flightPlannerService.addFlight(flight);
  }

  @GetMapping("flights/{id}")
  public ResponseEntity<Flight> fetchFlight(@PathVariable("id") int id){
    return flightPlannerService.fetchFlight(id);
  }

  @DeleteMapping("flights/{id}")
  public ResponseEntity<Flight> deleteFlight(@PathVariable("id") int id){
    return flightPlannerService.deleteFlight(id);
  }
}
