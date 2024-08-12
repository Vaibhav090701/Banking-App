package com.example.banking.App.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.App.modal.Bank;
import com.example.banking.App.modal.Branch;
import com.example.banking.App.modal.Services;
import com.example.banking.App.repository.BankRepository;
import com.example.banking.App.repository.BranchRepository;
import com.example.banking.App.repository.ServiceRepository;

import java.util.Arrays;
import java.util.List;

@Controller
public class BankController {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    // Create a new bank
//    @PostMapping("/banks")
//    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
//        Bank savedBank = bankRepository.save(bank);
//        return new ResponseEntity<>(savedBank, HttpStatus.CREATED);
//    }
//
//    // Create a new branch
//    @PostMapping("/branches")
//    public ResponseEntity<Branch> createBranch(@RequestBody Branch branch) {
//        Branch savedBranch = branchRepository.save(branch);
//        return new ResponseEntity<>(savedBranch, HttpStatus.CREATED);
//    }
//
//    // Create a new service
//    @PostMapping("/services")
//    public ResponseEntity<Services> createService(@RequestBody Services service) {
//        Services savedService = serviceRepository.save(service);
//        return new ResponseEntity<>(savedService, HttpStatus.CREATED);
//    }
//    

    @GetMapping("/branches")
    public String getBranches(Model model) {
        List<Bank> banks = bankRepository.findAll();
        model.addAttribute("banks", banks);
        return "branches"; // This should match the name of your Thymeleaf template file
    }

    @PostMapping("/branches")
    public String getBranchesByBankId(@RequestParam int bankId, Model model) {
        Bank bank = bankRepository.findById(bankId).orElse(null);
        if (bank != null) {
            List<Branch> branches = branchRepository.findByBankId(bankId);
            model.addAttribute("bank", bank);
            model.addAttribute("branches", branches);
            return "home"; // Return to the same page with updated data
        }
        return "error"; // Handle case where bank is not found
    }

        
    @GetMapping("/home")
    public String getHomePage(Model model) {
        List<Bank> banks = bankRepository.findAll();
        model.addAttribute("banks", banks);
        return "home";
    }
    
    @GetMapping("/services")
    public String getServices(@RequestParam int bankId, Model model) {
        Bank bank = bankRepository.findById(bankId).orElse(null);
        if (bank != null) {
            List<Services> services = serviceRepository.findByBankId(bankId);
            model.addAttribute("bank", bank);
            model.addAttribute("services", services);
            return "services"; // Assuming you have a services.html template
        }
        return "error"; // Handle case where bank is not found
    }

    

  
    // Get all banks
//    @GetMapping("/banks")
//    public ResponseEntity<List<Bank>> getAllBanks() {
//        List<Bank> banks = bankRepository.findAll();
//        return new ResponseEntity<>(banks, HttpStatus.OK);
//    }

}
