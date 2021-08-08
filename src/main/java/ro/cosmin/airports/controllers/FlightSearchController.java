package ro.cosmin.airports.controllers;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ro.cosmin.airports.services.FlightService;

import java.sql.Date;

@Controller
public class FlightSearchController {

    @Autowired
    private FlightService flightService;
//
//    @GetMapping("/searchFlight")
//    public String searchArrivalFlights(@RequestParam(value = "airport", required = false) String airport,
//                                       @RequestParam(value = "startDate", required = false) String startDate,
//                                       @RequestParam(value = "endDate", required = false) String endDate, Model model) {
//
//
//        model.addAttribute("listOfSearchedFlights", flightService.retriveFlightsByAirportAndByDate(airport, startDate, endDate));
//        return "flights";
//    }
}
