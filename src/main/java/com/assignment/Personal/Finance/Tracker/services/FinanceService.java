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
}
