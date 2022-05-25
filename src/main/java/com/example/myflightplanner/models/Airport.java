package com.example.myflightplanner.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Airport {

  @NotBlank
  private String country;

  @NotBlank
  private String city;

  @NotBlank
  @Id
  private String airport;

  public Airport(String country, String city, String airport) {
    this.country = country;
    this.city = city;
    this.airport = airport;
  }

  public Airport() {

  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getAirport() {
    return airport;
  }

  public void setAirport(String airport) {
    this.airport = airport;
  }

  public boolean equals(Airport airport) {
    return this.country.trim().equalsIgnoreCase(airport.country.trim())
        && this.city.trim().equalsIgnoreCase(airport.city.trim())
        && this.airport.trim().equalsIgnoreCase(airport.airport.trim());
  }

  public boolean containsPhrase(String phrase) {
    return this.country.toLowerCase().trim().contains(phrase.toLowerCase().trim())
        || this.city.toLowerCase().trim().contains(phrase.toLowerCase().trim())
        || this.airport.toLowerCase().trim().contains(phrase.toLowerCase().trim());
  }
}
