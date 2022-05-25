package com.example.myflightplanner.service;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.models.PageResult;
import com.example.myflightplanner.models.SearchFlight;
import java.util.List;

public interface UserService {

  public List<Airport> searchAirports(String phrase);

  public PageResult getSearchedFlights(SearchFlight searchFlight);

  public Flight fetchFlight(Integer id);

}
