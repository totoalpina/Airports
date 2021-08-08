package ro.cosmin.airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.cosmin.airports.models.AirportDto;
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

    @GetMapping("/searchFlight/{id}")
    public String searchArrivalFlights(@PathVariable(value = "id") Long id, final Model model) {
        model.addAttribute("airportDto", airportService.findById(id).orElseGet(AirportDto::new));
        model.addAttribute("listOfSearchedFlights", flightService.retrieveFlightsByAirportAndByDate(id));
        return "flights";
    }
}
