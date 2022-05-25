package com.example.myflightplanner.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Flight {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "flight_id_sequence")
  @Column(name = "FLIGHT_ID")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "from_id")
  private Airport from;

  @ManyToOne
  @JoinColumn(name = "to_id")
  private Airport to;

  @Column(name = "CARRIER")
  private String carrier;

  @Column(name = "DEPARTURE_TIME")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime departureTime;

  @Column(name = "ARRIVAL_TIME")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime arrivalTime;

  public Flight(Airport from, Airport to, String carrier,
      LocalDateTime departureTime, LocalDateTime arrivalTime) {
    this.from = from;
    this.to = to;
    this.carrier = carrier;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
  }

  public Flight() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public LocalDateTime getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(LocalDateTime departureTime) {
    this.departureTime = departureTime;
  }

  public LocalDateTime getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(LocalDateTime arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public boolean equals(Flight flight) {
    return this.from.equals(flight.from)
        && this.to.equals(flight.to)
        && this.carrier.equals(flight.carrier)
        && this.departureTime.equals(flight.departureTime)
        && this.arrivalTime.equals(flight.arrivalTime);
  }

  public boolean isBadDates() {
    return arrivalTime.isBefore(departureTime) || arrivalTime.isEqual(departureTime);
  }
}
