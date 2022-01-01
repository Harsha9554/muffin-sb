package com.haven.web;

import com.haven.model.MutualFund;
import com.haven.repository.MutualFundRepository;
import com.haven.service.MutualFundService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("mutual-funds")
public class MutualFundsController {
    private MutualFundService mutualFundService;
    private MutualFundRepository mutualFundRepository;

    public MutualFundsController(MutualFundService mutualFundService, MutualFundRepository mutualFundRepository) {
        this.mutualFundService = mutualFundService;
        this.mutualFundRepository = mutualFundRepository;
    }

    // @RequestMapping("/list")
    // public String allFunds(Model model) {
    // List<MutualFund> temp = new ArrayList<>();
    // List<MutualFund> mutualFundList = mutualFundRepository.getAllFunds();
    // temp.add(mutualFundList.get(0));
    // temp.add(mutualFundList.get(1));
    // temp.add(mutualFundList.get(2));
    // model.addAttribute("fundx", temp);
    // return "funds";
    // }

    @RequestMapping("/list")
    public String getAllPages(Model model) {
        return getOnePage(model, 1);
    }

    @RequestMapping("/list/page/{pageNumber}")
    public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
        Pageable fiveFunds = PageRequest.of(currentPage - 1, 15);
        Page<MutualFund> page = mutualFundRepository.getFundsPages(fiveFunds);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<MutualFund> mutualFunds = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("fundx", mutualFunds);

        return "funds";
    }
    // @RequestMapping("/list")
    // public String listFunds(Model model, @RequestParam("page") Optional<Integer>
    // page) {
    // int currentPage = page.orElse(1);
    // Pageable tenFunds = PageRequest.of(currentPage-1, 10);
    // Page<MutualFund> fundPage = mutualFundRepository.getFundsPages(tenFunds);

    // }

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
