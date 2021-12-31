package com.haven.web;

import com.haven.dto.UserRegistrationDto;
import com.haven.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("userx")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/signup")
    public String showRegistrationForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUserAccount(@ModelAttribute("userx") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/signup?success";
    }
}