package com.example.myflightplanner.controllers;

import com.example.myflightplanner.service.FlightPlannerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
  private final FlightPlannerService flightPlannerService;

  public UserController(FlightPlannerService flightPlannerService) {
    this.flightPlannerService = flightPlannerService;
  }


}
