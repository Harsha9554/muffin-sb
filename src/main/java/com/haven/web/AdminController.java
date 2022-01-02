package com.haven.web;

import com.haven.model.TrackingFunds;
import com.haven.model.User;
import com.haven.repository.TrackingFundsRepository;
import com.haven.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserRepository userRepository;
    private TrackingFundsRepository trackingFundsRepository;

    public AdminController(UserRepository userRepository, TrackingFundsRepository trackingFundsRepository) {
        this.userRepository = userRepository;
        this.trackingFundsRepository = trackingFundsRepository;
    }

    @GetMapping("/dashboard")
    public String hello(Model model) {
        List<User> users = userRepository.getAll();
        List<TrackingFunds> trackingFunds = trackingFundsRepository.findAll();
        model.addAttribute("userx",users);
        model.addAttribute("tfx",trackingFunds);
        return "admin";
    }

}
