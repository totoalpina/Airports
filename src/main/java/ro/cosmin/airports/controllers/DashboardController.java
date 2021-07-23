package ro.cosmin.airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.cosmin.airports.models.FlightDto;
import ro.cosmin.airports.services.AirlineService;
import ro.cosmin.airports.services.AirportService;
import ro.cosmin.airports.services.FlightService;

import javax.validation.Valid;

@Controller
public class DashboardController {


    @Autowired
    private FlightService flightService;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirportService airportService;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String dashboardPage(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Model model) {
        model.addAttribute("flights", flightService.retrieveAllFlights());
        model.addAttribute("airlines", airlineService.findAll());
        model.addAttribute("arrivalAirports", airportService.findAll());
        model.addAttribute("departureAirports", airportService.findAll());
        model.addAttribute("flightDto", new FlightDto());
        return "dashboard";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteFlight(@PathVariable("id") Long id, Model model) {
        model.addAttribute("flight", flightService.findById(id));
        flightService.deleteFlight(id);
        return "redirect:/dashboard?success";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editFlight(@PathVariable("id") Long id) {
        return "dashboard";
    }

    @GetMapping("/addFlight")
    @PreAuthorize("hasRole('ADMIN')")
    public String addFlight(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") @ModelAttribute("flightDto") FlightDto flightDto, Model model){
        model.addAttribute("flights", flightService.retrieveAllFlights());
        model.addAttribute("airlines", airlineService.findAll());
        model.addAttribute("arrivalAirports", airportService.findAll());
        model.addAttribute("departureAirports", airportService.findAll());
        model.addAttribute("flightDto", new FlightDto());
        return "add-flight";
    }

    @PostMapping("/createFlight")
    @PreAuthorize("hasRole('ADMIN')")
    public String createFlight(@Valid @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") @ModelAttribute("flightDto") FlightDto flightDto){
        flightService.addFlight(flightDto);
        return "redirect:/dashboard?success";
    }
}
