package com.example.myflightplanner.service;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.models.PageResult;
import com.example.myflightplanner.models.SearchFlight;
import com.example.myflightplanner.repository.FlightsRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

  private final FlightsRepository flightsRepository;

  public UserService(FlightsRepository flightsRepository) {
    this.flightsRepository = flightsRepository;
  }

  public List<Airport> searchAirports(String phrase) {
    return flightsRepository.searchAirports(phrase);
  }

  public PageResult getSearchedFlights(SearchFlight searchFlight) {
    if (searchFlight.getTo().equals(searchFlight.getFrom())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    return flightsRepository.getSearchedFlights(searchFlight);
  }

  public Flight fetchFlight(String id) {
    return flightsRepository.fetchFlight(id);
  }

}
