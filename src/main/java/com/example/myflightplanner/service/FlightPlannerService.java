package com.example.myflightplanner.service;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.repository.FlightsRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FlightPlannerService {

  private  FlightsRepository flightsRepository;

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
}
