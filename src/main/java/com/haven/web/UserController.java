package com.haven.web;

import javax.servlet.http.HttpServletRequest;

import com.haven.model.User;
import com.haven.repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/home")
    public String home(Model model, HttpServletRequest req) {
        String email = req.getUserPrincipal().getName();
        User user = userRepository.findByEmail(email);
        model.addAttribute("userx", user);
        return "home";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpServletRequest req) {
        String email = req.getUserPrincipal().getName();
        User user = userRepository.findByEmail(email);
        model.addAttribute("userx", user);
        return "dashboard";
    }
}
