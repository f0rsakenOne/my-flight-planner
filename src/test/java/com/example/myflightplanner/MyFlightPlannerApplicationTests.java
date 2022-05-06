package com.example.myflightplanner;

import com.example.myflightplanner.controllers.AdminController;
import com.example.myflightplanner.models.Airport;
import com.example.myflightplanner.models.Flight;
import com.example.myflightplanner.request.AddFlightRequest;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyFlightPlannerApplicationTests {

  @Autowired
  AdminController adminController;

  @Test
  void addFlightsTest() {
    Airport from = new Airport("Latvia", "Riga", "RIX");
    Airport to = new Airport("Estonia", "Tallin", "EST");
    String carrier = "Rix";
    String departureTime = "2022-05-02 08:30";
    String arrivalTime = "2022-05-02 10:30";
    AddFlightRequest addFlightRequest = new AddFlightRequest(from, to, carrier, departureTime,
        arrivalTime);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    Flight flight = adminController.addFlight(addFlightRequest);

    Assertions.assertNotNull(flight.getId());
    Assertions.assertEquals(flight.getFrom(),from);
    Assertions.assertEquals(flight.getTo(),to);
    Assertions.assertEquals(flight.getCarrier(),carrier);
    Assertions.assertEquals(flight.getDepartureTime().format(formatter),departureTime);
    Assertions.assertEquals(flight.getArrivalTime().format(formatter),arrivalTime);
  }

}
