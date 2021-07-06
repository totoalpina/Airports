package ro.cosmin.Airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ro.cosmin.Airports.repository.UserRepository;

@Controller
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    @PreAuthorize("permitAll()")
    public String signupForm() {
        return "signup";
    }
}
