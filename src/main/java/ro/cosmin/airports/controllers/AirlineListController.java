package ro.cosmin.airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.cosmin.airports.entities.Airline;
import ro.cosmin.airports.models.AirlineDto;
import ro.cosmin.airports.models.AirportDto;
import ro.cosmin.airports.services.AirlineService;
import ro.cosmin.airports.services.FlightService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AirlineListController {

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private FlightService flightService;

    @GetMapping("/airlines/{page}")
    public String objectsListPage(@PathVariable("page") Integer page, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 12, Sort.Direction.ASC, "airlineName");
        Page<Airline> airlinePage = airlineService.findAll(pageable);
        int totalPages = airlinePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("activeAirlineList", true);
        model.addAttribute("airlineList", airlinePage.getContent());
        return "airlines";
    }

    @GetMapping("/searchFlightsByAirline/{id}")
    public String searchFlights(@PathVariable(value = "id") Long id, final Model model) {
        model.addAttribute("airlineDto", airlineService.findById(id).orElseGet(AirlineDto::new));
        model.addAttribute("airlineFlightslist", flightService.findFlightByAirline(id));
        return "airline-flights";
    }
}
