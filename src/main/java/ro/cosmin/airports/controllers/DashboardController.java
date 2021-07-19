package ro.cosmin.airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteFlight(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("flight", flightService.findById(id));
        flightService.deleteFlight(id);
        return "redirect:/dashboard?success";
    }

    @GetMapping("/edit/{id}")
    public String editFlight(@PathVariable("id") Long id, Model model) {
        model.addAttribute("flight", flightService.findById(id));
        return "dashboard";
    }

}
