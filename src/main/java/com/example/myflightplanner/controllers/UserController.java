package com.example.myflightplanner.controllers;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.models.PageResult;
import com.example.myflightplanner.request.SearchFlightRequest;
import com.example.myflightplanner.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }


  @GetMapping("airports")
  @ResponseStatus(HttpStatus.OK)
  public List<Airport> searchAirports(@RequestParam("search") String search) {
    return userService.searchAirports(search);
  }

  @PostMapping("flights/search")
  @ResponseStatus(HttpStatus.OK)
  public PageResult getSearchedFlights(@Valid @RequestBody SearchFlightRequest searchFlightRequest) {
    return userService.getSearchedFlights(searchFlightRequest.toDomain());
  }

  @GetMapping("flights/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Flight fetchFlight(@PathVariable("id") String id) {
    return userService.fetchFlight(id);
  }

}
