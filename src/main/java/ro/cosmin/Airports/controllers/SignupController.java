package ro.cosmin.Airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import ro.cosmin.Airports.domain.User;
import ro.cosmin.Airports.enums.UserRole;
import ro.cosmin.Airports.models.UserDto;
import ro.cosmin.Airports.repository.UserRepository;
import ro.cosmin.Airports.services.UserService;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;


    @GetMapping("/signup")
    @PreAuthorize("permitAll()")
    public String signupForm(final UserDto userDto, final Model model) {
        model.addAttribute("userDto", userDto);
        return "signup";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("userDto") final UserDto userDto, final Model model){
        model.addAttribute("userDto", userDto);
        userService.save(userDto);
        return "redirect:/signup?success";
    }
}
