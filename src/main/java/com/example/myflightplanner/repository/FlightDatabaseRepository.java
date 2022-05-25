package com.example.myflightplanner.repository;

import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightDatabaseRepository extends JpaRepository<Flight, Integer> {

  @Query("select case when count(f) > 0 then true else false end from Flight f where "
      + "f.from = :from_id and "
      + "f.to=:to_id and "
      + "f.carrier=:carrier and "
      + "f.departureTime = :departure_time and "
      + "f.arrivalTime = :arrival_time")
  boolean containsSameFlight(
      @Param("from_id") Airport from,
      @Param("to_id") Airport to,
      @Param("carrier") String carrier,
      @Param("departure_time") LocalDateTime departureTime,
      @Param("arrival_time") LocalDateTime arrivalTime
  );

  @Query("select f as date from Flight f where "
      + "f.from.airport=:from and "
      + "f.to.airport=:to and "
      + "f.departureTime>=:departure_date_beginning and f.departureTime<=:departure_date_end")
  List<Flight> getSearchedFlights(@Param("from") String from,
      @Param("to") String to,
      @Param("departure_date_beginning") LocalDateTime departureDateBeginning,
      @Param("departure_date_end") LocalDateTime departureDateEnd);
}
