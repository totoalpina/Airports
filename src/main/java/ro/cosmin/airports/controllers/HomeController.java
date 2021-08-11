package ro.cosmin.airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.cosmin.airports.models.AirlineDto;
import ro.cosmin.airports.models.AirportDto;
import ro.cosmin.airports.services.AirlineService;
import ro.cosmin.airports.services.AirportService;
import ro.cosmin.airports.services.FlightService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {

    private DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirportService airportService;

    @GetMapping({"/", "/home", "/index",})
    public String homePage(final Model model) {
        model.addAttribute("airports", airportService.findAll());
        model.addAttribute("airlines", airlineService.findAll());
        return "index";
    }

    @GetMapping("/searchByAirport")
    public String search(@RequestParam(value = "id") Long id,
                         @RequestParam(value = "startDate") String startDate,
                         @RequestParam(value = "endDate") String endDate,
                         @RequestParam(value = "flightType") String flightType,
                         final Model model) {

        LocalDateTime sd = LocalDateTime.parse(startDate);
        LocalDateTime ed = LocalDateTime.parse(endDate);
        model.addAttribute("airportDto", airportService.findById(id).orElseGet(AirportDto::new));
        if (flightType.equals("departure")) {
            model.addAttribute("listDepartureAfterSearch", flightService.searchDepartureFlightsByAirportBetweenTwoDates(id, sd, ed));
            return "search-flights";
        }else if (flightType.equals("arrival")){
            model.addAttribute("listArrivalAfterSearch", flightService.searchArrivalFlightsByAirportBetweenTwoDates(id, sd, ed));
            return "search-flights";
        } else {
            model.addAttribute("listArrivalAfterSearch", flightService.searchArrivalFlightsByAirportBetweenTwoDates(id, sd, ed));
            model.addAttribute("listDepartureAfterSearch", flightService.searchDepartureFlightsByAirportBetweenTwoDates(id, sd, ed));
            return "search-flights";
        }
    }

    @GetMapping("/searchByAirline")
    public String search(@RequestParam(value = "id") Long id,
                         @RequestParam(value = "startDate") String startDate,
                         @RequestParam(value = "endDate") String endDate,
                         final Model model) {

        LocalDateTime sd = LocalDateTime.parse(startDate);
        LocalDateTime ed = LocalDateTime.parse(endDate);
        model.addAttribute("airlineDto", airlineService.findById(id).orElseGet(AirlineDto::new));
        model.addAttribute("listOfSearchedFlights", flightService.searchFlightsByAirlineBetweenTwoDates(id, sd, ed));
        return "search-airline";
    }
}
