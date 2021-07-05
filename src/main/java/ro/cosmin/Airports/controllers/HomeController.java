package ro.cosmin.Airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.cosmin.Airports.services.AirportService;

@Controller
public class HomeController {

    @Autowired
    private AirportService airportService;

    @GetMapping({"/", "/home", "/index"})
    public String homePage(final Model model){
        model.addAttribute("airports", airportService.findAll());
        return "index";
    }
}
