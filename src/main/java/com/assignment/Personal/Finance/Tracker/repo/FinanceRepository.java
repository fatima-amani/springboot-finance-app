package com.assignment.Personal.Finance.Tracker.repo;

import com.assignment.Personal.Finance.Tracker.dto.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends JpaRepository<Finance,Integer> {
}
