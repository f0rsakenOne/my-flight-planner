package com.example.myflightplanner.request;

import com.example.myflightplanner.models.SearchFlight;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.NotBlank;

public class SearchFlightRequest {

  @NotBlank
  private String from;
  @NotBlank
  private String to;
  @NotBlank
  private String departureDate;

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public SearchFlightRequest(String from, String to, String departureDate) {
    this.from = from;
    this.to = to;
    this.departureDate = departureDate;
  }

  public SearchFlight toDomain() {
    return new SearchFlight(from, to, LocalDate.parse(departureDate, formatter));
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }
}
