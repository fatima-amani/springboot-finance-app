package com.assignment.Personal.Finance.Tracker.services;

import com.assignment.Personal.Finance.Tracker.dto.Finance;
import com.assignment.Personal.Finance.Tracker.dto.FinanceSummaryDTO;
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

    public String deleteEntryByID(int id) {
        if (financeRepository.existsById(id)) {
            financeRepository.deleteById(id);
            return "Deleted successfully";
        } else {
            throw new RuntimeException("Entry not found with ID: " + id);
        }
    }

    public FinanceSummaryDTO getFinanceSummary() {
        List<Finance> finances = financeRepository.findAll();

        double totalIncome = finances.stream()
                .filter(finance -> finance.getAmount() > 0) // Assuming positive amounts are income
                .mapToDouble(Finance::getAmount)
                .sum();

        double totalExpenses = finances.stream()
                .filter(finance -> finance.getAmount() < 0) // Assuming negative amounts are expenses
                .mapToDouble(finance -> Math.abs(finance.getAmount())) // Convert to positive for sum
                .sum();

        return new FinanceSummaryDTO(totalIncome, totalExpenses);
    }

}
