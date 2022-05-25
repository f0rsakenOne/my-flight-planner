package com.example.myflightplanner.repository;

import com.example.myflightplanner.models.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AirportDatabaseRepository extends JpaRepository<Airport, String> {

  @Query("select a from Airport a where lower(concat(a.airport, a.city, a.country))  like %:phrase%")
  List<Airport> searchAirport(@Param("phrase") String phrase);
}
