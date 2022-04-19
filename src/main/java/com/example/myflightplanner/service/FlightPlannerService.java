package com.example.myflightplanner.service;

import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.repository.FlightsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FlightPlannerService {

  private final FlightsRepository flightsRepository;

  public FlightPlannerService(FlightsRepository flightsRepository) {
    this.flightsRepository = flightsRepository;
  }

  public void clear() {
    flightsRepository.clear();
  }

  public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
    return flightsRepository.addFlight(flight);
  }

  public ResponseEntity<Flight> fetchFlight(int id){
    return flightsRepository.fetchFlight(id);
  }

  public ResponseEntity<Flight> deleteFlight(int id){
    return flightsRepository.deleteFlight(id);
  }
}
