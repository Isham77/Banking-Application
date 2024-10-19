package com.springs.controller;

import com.springs.model.Bank;
import com.springs.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BankController {

    @Autowired
    private BankRepository bankRepository;

    @GetMapping("/bank/{bankName}/branches")
    public String showBranches(@PathVariable("bankName") String bankName, Model model) {
        // Fetch bank by name
        Bank bank = bankRepository.findByBankName(bankName);

        if (bank != null) {
            model.addAttribute("bankName", bank.getBankName());
            model.addAttribute("branches", bank.getBranches());
        } else {
            model.addAttribute("errorMessage", "Bank not found");
        }

        return "branches";  // Return the name of the HTML template
    }

    @GetMapping("/bank/{bankName}/services")
    public String showServices(@PathVariable("bankName") String bankName, Model model) {
        // Fetch bank by name
        Bank bank = bankRepository.findByBankName(bankName);

        if (bank != null) {
            model.addAttribute("bankName", bank.getBankName());
            model.addAttribute("services", bank.getServices());
        } else {
            model.addAttribute("errorMessage", "Bank not found");
        }

        return "services";  // Return the name of the HTML template
    }
}

