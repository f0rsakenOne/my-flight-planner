package com.example.myflightplanner.service.memory;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.models.PageResult;
import com.example.myflightplanner.models.SearchFlight;
import com.example.myflightplanner.repository.FlightsRepository;
import com.example.myflightplanner.service.UserService;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@ConditionalOnProperty(prefix = "flight-planner", name = "store-type", havingValue = "in-memory")
public class UserServiceImpl implements UserService {

  private final FlightsRepository flightsRepository;

  public UserServiceImpl(FlightsRepository flightsRepository) {
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

  public Flight fetchFlight(Integer id) {
    return flightsRepository.fetchFlight(id);
  }

}
