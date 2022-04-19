package com.example.myflightplanner.repository;

import com.example.myflightplanner.models.Flight;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class FlightsRepository {

  private int flightIdCount = 0;
  List<Flight> flightList = new ArrayList<>();

  public void clear() {
    flightList.clear();
  }

  public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
    if (containsSameFlights(flight)) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    if (containsSameAirports(flight)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    if (validateDate(flight)) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    flight.setId(flightIdCount);
    flightIdCount++;
    flightList.add(flight);
    return new ResponseEntity<>(flight, HttpStatus.CREATED);
  }

  private boolean containsSameFlights(Flight flight) {
    return flightList.stream().anyMatch(flight::equals);
  }

  private boolean containsSameAirports(Flight flight) {
    return flight.getFrom().getAirport().trim()
        .equalsIgnoreCase(flight.getTo().getAirport().trim());
  }

  private boolean validateDate(Flight flight) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDate departureDate = LocalDate.parse(flight.getDepartureTime(), formatter);
    LocalDate arrivalDate = LocalDate.parse(flight.getArrivalTime(), formatter);
    return arrivalDate.isBefore(departureDate) || arrivalDate.isEqual(departureDate);
  }

  public ResponseEntity<Flight> fetchFlight(int id){
    if (checkIfPresent(id)){
      return new ResponseEntity<>(getFlightById(id),HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  public ResponseEntity<Flight> deleteFlight(int id){
    flightList.removeIf(flight -> flight.getId()==id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private boolean checkIfPresent(int id){
    return flightList.stream().anyMatch(flight -> flight.getId()==id);
  }

  private Flight getFlightById(int id){
    return (Flight) flightList.stream().map(Flight::getId).filter(integer -> integer==id);
  }

}
