package com.example.myflightplanner.service;

import com.example.myflightplanner.models.Flight;

public interface AdminService {

  void addFlight(Flight flight);

  Flight fetchFlight(Integer id);

  void deleteFlight(Integer id);
}
