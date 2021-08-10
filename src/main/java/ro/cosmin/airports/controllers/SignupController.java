package ro.cosmin.airports.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.cosmin.airports.models.UserDto;
import ro.cosmin.airports.services.UserService;

import javax.validation.Valid;

@Controller
public class SignupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SignupController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    @PreAuthorize("permitAll()")
    public String signupForm(final UserDto userDto, final Model model) {
        model.addAttribute("userDto", new UserDto());
        return "signup";
    }

    @PostMapping("/register")
    public String saveUser(@Valid final UserDto userDto,final BindingResult bindingResult, final Model model) {

        if (bindingResult.hasErrors()) {
            LOGGER.debug("Errors in the form : {}", bindingResult);
            model.addAttribute("userDto", userDto);
            return "signup";
        } else {
            userService.save(userDto);
            return "redirect:/signup?success";
        }
    }
}
