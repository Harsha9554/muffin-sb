package com.haven.web;

import com.haven.model.MutualFund;
import com.haven.repository.MutualFundRepository;
import com.haven.service.MutualFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        model.addAttribute("fundx",temp);
        return "funds";
    }

}
