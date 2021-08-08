package ro.cosmin.airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.cosmin.airports.entities.Airport;
import ro.cosmin.airports.models.AirportDto;
import ro.cosmin.airports.services.AirlineService;
import ro.cosmin.airports.services.AirportService;
import ro.cosmin.airports.services.FlightService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class AirportListController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/airports/{page}")
    public String objectsListPage(@PathVariable("page") Integer page, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 13, Sort.Direction.ASC, "airportName");
        Page<Airport> airportPage = airportService.findAll(pageable);
        int totalPages = airportPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("activeAirportList", true);
        model.addAttribute("airportList", airportPage.getContent());

        return "airports";
    }

    @GetMapping("/searchFlight/{id}")
    public String searchFlights(@PathVariable(value = "id") Long id, final Model model) {
        model.addAttribute("airportDto", airportService.findById(id).orElseGet(AirportDto::new));
        model.addAttribute("listOfSearchedFlights", flightService.findDepartureFlightByAirport(id));
        model.addAttribute("listArrivalFlights", flightService.findArrivalFlightByAirport(id));
        return "flights";
    }


}
