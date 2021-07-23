package ro.cosmin.airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.cosmin.airports.services.FlightService;

@Controller
public class HomeController {

    @Autowired
    private FlightService flightService;

    @GetMapping({"/", "/home", "/index",})
    public String homePage(String airport,
                           String startDate,
                           String endDate, Model model) {
        model.addAttribute("airport", airport);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        return "index";
    }

    @GetMapping("/searchFlight")
    public String searchArrivalFlights(@RequestParam(value = "airport", required = false) String airport,
                                       @RequestParam(value = "startDate", required = false) String startDate,
                                       @RequestParam(value = "endDate", required = false) String endDate, Model model) {


        model.addAttribute("listOfSearchedFlights", flightService.retrieveFlightsByAirportAndByDate(airport, startDate, endDate));
        return "flights";
    }
}
