package com.assignment.Personal.Finance.Tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinanceSummaryDTO {
    private double totalIncome;
    private double totalExpenses;
}
