package com.bank.api.data.model;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String accountNumber;
    @Column
    private Double amount;
    @Column
    private  Double discountedAmount;
    @Column
    private int rate;
    @Column
    private Date transactionDate;
    @Column
    @Transient
    private int transactionPerAccountCount;


}
