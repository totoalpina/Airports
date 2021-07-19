package ro.cosmin.airports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.cosmin.airports.models.UserDto;
import ro.cosmin.airports.services.UserService;

import javax.validation.Valid;

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


    @PostMapping("/register")
    public String saveUser(@Valid @ModelAttribute("userDto") final UserDto userDto, final Model model){

        model.addAttribute("userDto", userDto);
        userService.save(userDto);
        return "redirect:/signup?success";
    }
}
