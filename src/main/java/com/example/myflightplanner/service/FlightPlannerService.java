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
public class FlightPlannerService {

  private final FlightsRepository flightsRepository;

  public FlightPlannerService(FlightsRepository flightsRepository) {
    this.flightsRepository = flightsRepository;
  }

  public void clear() {
    flightsRepository.clear();
  }

  public int getNewId() {
    return flightsRepository.getNewId();
  }

  public void addFlight(Flight flight) {
    flightsRepository.addFlight(flight);
  }


  public Flight fetchFlight(int id) {
    return flightsRepository.fetchFlight(id);
  }

  public void deleteFlight(int id) {
    flightsRepository.deleteFlight(id);
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
}
