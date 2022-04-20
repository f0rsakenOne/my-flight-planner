package com.example.myflightplanner.repository;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.models.PageResult;
import com.example.myflightplanner.models.SearchFlight;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class FlightsRepository {

  private int flightIdCount = 0;
  List<Flight> flightList = new ArrayList<>();

  public void clear() {
    flightList.clear();
  }

  public int getNewId() {
    int newId = flightIdCount;
    flightIdCount++;
    return newId;
  }

  public synchronized void addFlight(Flight flight) {
    if (flightList.stream().anyMatch(flight::equals)) {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    if (flight.getFrom().equals(flight.getTo())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    if (flight.isBadDates()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    flightList.add(flight);
  }

  public Flight fetchFlight(Integer id) {
    return flightList.stream().filter(flight -> flight.getId().equals(id)).findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  public void deleteFlight(int id) {
    flightList.removeIf(flight -> flight.getId().equals(id));
  }

  public List<Airport> searchAirports(String phrase) {
    return flightList.stream().map(Flight::getFrom)
        .filter(airport -> airport.containsPhrase(phrase)).toList();
  }

  public PageResult getSearchedFlights(SearchFlight searchFlight) {
    List<Flight> list =  flightList.stream().filter(searchFlight::equalsToFlight).toList();
    return new PageResult(list);
  }
}
