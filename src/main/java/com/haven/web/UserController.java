package com.haven.web;

import javax.servlet.http.HttpServletRequest;

import com.haven.model.MutualFund;
import com.haven.model.TrackingFunds;
import com.haven.model.User;
import com.haven.repository.MutualFundRepository;
import com.haven.repository.TrackingFundsRepository;
import com.haven.repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;
    private TrackingFundsRepository trackingFundsRepository;
    private MutualFundRepository mutualFundRepository;

    public UserController(UserRepository userRepository, TrackingFundsRepository trackingFundsRepository, MutualFundRepository mutualFundRepository) {
        this.userRepository = userRepository;
        this.trackingFundsRepository = trackingFundsRepository;
        this.mutualFundRepository = mutualFundRepository;
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
        System.out.println(user.getId());
        System.out.println(user.getCompleteName());
        List<TrackingFunds> tf = trackingFundsRepository.findTrackingFundsByUserId(user.getId());
        model.addAttribute("userx", user);
        model.addAttribute("tfundx",tf);
        return "dashboard";
    }

    @GetMapping("/dashboard/{code}")
    public String addFundToUser(Model model, HttpServletRequest req, @PathVariable("code") String code) {
        String email = req.getUserPrincipal().getName();
        User user = userRepository.findByEmail(email);
        MutualFund m = mutualFundRepository.getMutualFundByCode(code);
        TrackingFunds t = new TrackingFunds(user.getId(), code, m.getName());
        trackingFundsRepository.save(t);
        return dashboard(model, req);
    }
}
