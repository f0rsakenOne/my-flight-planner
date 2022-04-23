package com.example.myflightplanner.service;

import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.repository.FlightsRepository;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminService {

  private final FlightsRepository flightsRepository;

  public AdminService(FlightsRepository flightsRepository) {
    this.flightsRepository = flightsRepository;
  }

  public void addFlight(Flight flight) {
    if (flightsRepository.isSameFlight(flight)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    if (flight.getFrom().equals(flight.getTo())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (flight.isBadDates()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    flightsRepository.addFlight(flight);
  }

  public String getNewId() {
    return UUID.randomUUID().toString();
  }

  public Flight fetchFlight(String id) {
    return flightsRepository.fetchFlight(id);
  }

  public void deleteFlight(String id) {
    flightsRepository.deleteFlight(id);
  }
}
