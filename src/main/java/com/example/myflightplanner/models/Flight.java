package com.example.myflightplanner.models;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Flight {

  private int id;

  @Valid
  @NotNull
  private Airport from;

  @Valid
  @NotNull
  private Airport to;

  @NotBlank
  private String carrier;

  @NotBlank
  private String departureTime;

  @NotBlank
  private String arrivalTime;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Airport getFrom() {
    return from;
  }

  public void setFrom(Airport from) {
    this.from = from;
  }

  public Airport getTo() {
    return to;
  }

  public void setTo(Airport to) {
    this.to = to;
  }

  public String getCarrier() {
    return carrier;
  }

  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public String getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Flight flight = (Flight) o;
    return Objects.equals(from, flight.from) && Objects.equals(to, flight.to)
        && Objects.equals(carrier, flight.carrier) && Objects.equals(
        departureTime, flight.departureTime) && Objects.equals(arrivalTime,
        flight.arrivalTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to, carrier, departureTime, arrivalTime);
  }
}
