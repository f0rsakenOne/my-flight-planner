package com.example.myflightplanner.controllers;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.service.FlightPlannerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {
  private final FlightPlannerService flightPlannerService;

  public UserController(FlightPlannerService flightPlannerService) {
    this.flightPlannerService = flightPlannerService;
  }

  @GetMapping("airports")
  @ResponseStatus(HttpStatus.OK)
  public List<Airport> searchAirports(@RequestParam("search") String search) {
    return flightPlannerService.searchAirports(search);
  }

}
