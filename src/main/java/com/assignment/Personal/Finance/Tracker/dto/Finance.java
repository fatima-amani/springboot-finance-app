package com.assignment.Personal.Finance.Tracker.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private float amount;
    private LocalDate date;
    private String category;
    private String description;
}
