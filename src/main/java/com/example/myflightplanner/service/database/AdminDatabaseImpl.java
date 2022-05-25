package com.example.myflightplanner.service.database;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.repository.AirportDatabaseRepository;
import com.example.myflightplanner.repository.FlightDatabaseRepository;
import com.example.myflightplanner.service.AdminService;
import java.util.Optional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@ConditionalOnProperty(prefix = "flight-planner", name = "store-type", havingValue = "database")
public class AdminDatabaseImpl implements AdminService {

  private final FlightDatabaseRepository flightDatabaseRepository;

  private final AirportDatabaseRepository airportDatabaseRepository;

  public AdminDatabaseImpl(FlightDatabaseRepository flightDatabaseRepository,
      AirportDatabaseRepository airportDatabaseRepository) {
    this.flightDatabaseRepository = flightDatabaseRepository;
    this.airportDatabaseRepository = airportDatabaseRepository;
  }

  @Override
  public void addFlight(Flight flight) {
    if (flightDatabaseRepository.containsSameFlight(
        flight.getFrom(), flight.getTo(), flight.getCarrier(), flight.getDepartureTime(),
        flight.getArrivalTime())) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    if (flight.getFrom().equals(flight.getTo())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (flight.isBadDates()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    flight.setFrom(findOrCreateAirport(flight.getFrom()));
    flight.setTo(findOrCreateAirport(flight.getTo()));
    flightDatabaseRepository.save(flight);
  }

  private Airport findOrCreateAirport(Airport airport) {
    Optional<Airport> existingAirport = airportDatabaseRepository.findById(airport.getAirport());
    return existingAirport.orElseGet(() -> airportDatabaseRepository.save(airport));
  }

  @Override
  public Flight fetchFlight(Integer id) {
    return flightDatabaseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND));
  }

  @Override
  public void deleteFlight(Integer id) {
    flightDatabaseRepository.deleteById(id);
  }
}
