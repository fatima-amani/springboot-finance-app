package com.assignment.Personal.Finance.Tracker.services;

import com.assignment.Personal.Finance.Tracker.dto.Finance;
import com.assignment.Personal.Finance.Tracker.repo.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceService {

    @Autowired
    FinanceRepository financeRepository;

    public List<Finance> getAllEntries(){
        return financeRepository.findAll();
    }

    public Finance createFinance(Finance finance) {
        return financeRepository.save(finance);
    }

    public Finance getEntryById(int id) {
        return financeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Finance entry not found with id: " + id));
    }

    public Finance updateEntryByID(Finance finance, int id) {
        return financeRepository.findById(id)
                .map(entry -> {
                    entry.setAmount(finance.getAmount());
                    entry.setCategory(finance.getCategory());
                    entry.setDate(finance.getDate());
                    entry.setDescription(finance.getDescription());
                    return financeRepository.save(entry);
                })
                .orElseThrow(() -> new RuntimeException("Entry not found"));
    }
}
