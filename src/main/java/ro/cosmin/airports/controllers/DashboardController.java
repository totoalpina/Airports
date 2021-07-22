package ro.cosmin.airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.cosmin.airports.models.FlightDto;
import ro.cosmin.airports.services.AirlineService;
import ro.cosmin.airports.services.AirportService;
import ro.cosmin.airports.services.FlightService;


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
    public String dashboardPage(Model model) {
        model.addAttribute("flights", flightService.retrieveAllFlights());
        model.addAttribute("editAirlines", airlineService.findAll());
        return "dashboard";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteFlight(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("flight", flightService.findById(id));
        flightService.deleteFlight(id);
        return "redirect:/dashboard?success";
    }

    @GetMapping("/editFlight/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditPage(@PathVariable("id") Long id, Model model) {
        FlightDto flight = flightService.findById(id).get();
        model.addAttribute("flight", flight);
        model.addAttribute("editAirlines", airlineService.findAll());
        model.addAttribute("arrivalAirports", airportService.findAll());
        model.addAttribute("departureAirports", airportService.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public String editFlight(@ModelAttribute FlightDto flight) {
        flightService.updateFlight(flight.getId());
        return "redirect:/dashboard";
    }

}
