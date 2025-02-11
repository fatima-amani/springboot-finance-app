package com.assignment.Personal.Finance.Tracker.controller;

import com.assignment.Personal.Finance.Tracker.dto.Finance;
import com.assignment.Personal.Finance.Tracker.repo.FinanceRepository;
import com.assignment.Personal.Finance.Tracker.services.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entries")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping()
    public List<Finance> getAllEntries() {
        return financeService.getAllEntries();

    }

    @PostMapping
    public Finance createTransaction(@RequestBody Finance finance) {
        return financeService.createFinance(finance);
    }


}
