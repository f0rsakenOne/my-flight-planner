package com.example.myflightplanner.controllers;

import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.request.AddFlightRequest;
import com.example.myflightplanner.service.AdminService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin-api")
public class AdminController {

  private final AdminService adminService;

  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  @PutMapping("flights")
  @ResponseStatus(HttpStatus.CREATED)
  public Flight addFlight(@Valid @RequestBody AddFlightRequest flightRequest) {
    Flight flight = flightRequest.toDomain();
    adminService.addFlight(flight);
    return flight;
  }

  @GetMapping("flights/{id}")
  public Flight fetchFlight(@PathVariable("id") Integer id) {
    return adminService.fetchFlight(id);
  }

  @DeleteMapping("flights/{id}")
  public void deleteFlight(@PathVariable("id") Integer id) {
    adminService.deleteFlight(id);
  }
}
