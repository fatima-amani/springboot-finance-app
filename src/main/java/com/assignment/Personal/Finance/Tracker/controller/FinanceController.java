package com.assignment.Personal.Finance.Tracker.controller;

import com.assignment.Personal.Finance.Tracker.dto.Finance;
import com.assignment.Personal.Finance.Tracker.dto.FinanceSummaryDTO;
import com.assignment.Personal.Finance.Tracker.services.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entries")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping()
    public ResponseEntity<List<Finance>> getAllEntries() {
        List<Finance> entries = financeService.getAllEntries();
        return ResponseEntity.ok(entries);
    }

    @PostMapping()
    public ResponseEntity<Finance> createFinance(@RequestBody Finance finance) {
        Finance createdFinance = financeService.createFinance(finance);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFinance);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Finance> getEntryByID(@PathVariable("id") Integer id) {
        Finance finance = financeService.getEntryById(id);
        return ResponseEntity.ok(finance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Finance> updateEntryByID(@RequestBody Finance finance,
                                                   @PathVariable("id") Integer id) {
        Finance updatedFinance = financeService.updateEntryByID(finance, id);
        return ResponseEntity.ok(updatedFinance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntryByID(@PathVariable("id") Integer id) {
        String message = financeService.deleteEntryByID(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/summary")
    public ResponseEntity<FinanceSummaryDTO> getFinanceSummary() {
        FinanceSummaryDTO summary = financeService.getFinanceSummary();
        return ResponseEntity.ok(summary);
    }
}
