package com.example.myflightplanner.repository;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.models.PageResult;
import com.example.myflightplanner.models.SearchFlight;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class FlightsRepository {

  List<Flight> flightList = Collections.synchronizedList(new ArrayList<>());

  public void clear() {
    flightList.clear();
  }



  public  void addFlight(Flight flight) {
    flightList.add(flight);
  }

  public boolean isSameFlight(Flight flight) {
    return flightList.stream().anyMatch(flight::equals);
  }

  public Flight fetchFlight(String id) {
    return flightList.stream().filter(flight -> flight.getId().equals(id)).findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }


  public  void deleteFlight(String id) {
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
