package com.example.myflightplanner.service.database;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.models.PageResult;
import com.example.myflightplanner.models.SearchFlight;
import com.example.myflightplanner.repository.AirportDatabaseRepository;
import com.example.myflightplanner.repository.FlightDatabaseRepository;
import com.example.myflightplanner.service.UserService;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@ConditionalOnProperty(prefix = "flight-planner", name = "store-type", havingValue = "database")
public class UserDatabaseImpl implements UserService {

  private final FlightDatabaseRepository flightDatabaseRepository;
  private final AirportDatabaseRepository airportDatabaseRepository;

  public UserDatabaseImpl(FlightDatabaseRepository flightDatabaseRepository,
      AirportDatabaseRepository airportDatabaseRepository) {
    this.flightDatabaseRepository = flightDatabaseRepository;
    this.airportDatabaseRepository = airportDatabaseRepository;
  }

  @Override
  public List<Airport> searchAirports(String phrase) {
    return airportDatabaseRepository.searchAirport(phrase.toLowerCase().trim());
  }

  @Override
  public PageResult getSearchedFlights(SearchFlight searchFlight) {
    if (searchFlight.getTo().equals(searchFlight.getFrom())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    List<Flight> flightList = flightDatabaseRepository.getSearchedFlights(searchFlight.getFrom(),
        searchFlight.getTo(), searchFlight.getDepartureDate().atStartOfDay(),
        searchFlight.getDepartureDate().plusDays(1).atStartOfDay());
    return new PageResult(flightList);
  }

  @Override
  public Flight fetchFlight(Integer id) {
    return flightDatabaseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND));
  }
}
