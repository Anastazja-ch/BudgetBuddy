package com.budget.budget.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private BigDecimal amount;
    private LocalDateTime date;
    private String updatedBy;
    private LocalDateTime updatedAt;
}

