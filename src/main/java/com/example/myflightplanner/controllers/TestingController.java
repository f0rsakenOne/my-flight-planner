package com.example.myflightplanner.controllers;

import com.example.myflightplanner.service.FlightPlannerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing-api")
public class TestingController {

  private final FlightPlannerService flightPlannerService;

  private TestingController(FlightPlannerService flightPlannerService) {
    this.flightPlannerService = flightPlannerService;
  }

  @PostMapping("/clear")
  public void clear() {
    flightPlannerService.clear();
  }
}
