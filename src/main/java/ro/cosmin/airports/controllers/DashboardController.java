package ro.cosmin.airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.cosmin.airports.services.FlightService;

@Controller
public class DashboardController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String dashboardPage(Model model) {
        model.addAttribute("flights", flightService.retrieveAllFlights());
        return "dashboard";
    }

}
