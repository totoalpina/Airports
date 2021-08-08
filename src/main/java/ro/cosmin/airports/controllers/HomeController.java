package ro.cosmin.airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ro.cosmin.airports.services.AirportService;
import ro.cosmin.airports.services.FlightService;

@Controller
public class HomeController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirportService airportService;

    @GetMapping({"/", "/home", "/index",})
    public String homePage() {
        return "index";
    }
}
