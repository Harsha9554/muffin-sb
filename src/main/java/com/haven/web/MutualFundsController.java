package com.haven.web;

import com.haven.model.MutualFund;
import com.haven.repository.MutualFundRepository;
import com.haven.service.MutualFundService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("mutual-funds")
public class MutualFundsController {
    private MutualFundService mutualFundService;
    private MutualFundRepository mutualFundRepository;

    public MutualFundsController(MutualFundService mutualFundService, MutualFundRepository mutualFundRepository) {
        this.mutualFundService = mutualFundService;
        this.mutualFundRepository = mutualFundRepository;
    }

    @RequestMapping("/list")
    public String allFunds(Model model) {
        List<MutualFund> temp = new ArrayList<>();
        List<MutualFund> mutualFundList = mutualFundRepository.getAllFunds();
        temp.add(mutualFundList.get(0));
        temp.add(mutualFundList.get(1));
        temp.add(mutualFundList.get(2));
        model.addAttribute("fundx", temp);
        return "funds";
    }

    @RequestMapping("/list/{code}")
    public String getFund(@PathVariable("code") String code, Model model) {
        MutualFund m2 = mutualFundRepository.getMutualFundByCode(code);
        System.out.println(m2.getName());
        if (m2 != null) {
            model.addAttribute("funx", m2);
            return "fund";
        } else {
            return "redirect:fund?error";
        }
    }

}
