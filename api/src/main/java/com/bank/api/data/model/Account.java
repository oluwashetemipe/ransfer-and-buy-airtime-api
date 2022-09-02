package com.bank.api.data.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column
    private String accountNumber;
    @Column
    private Long customerId;
    @Column
    private Double accountBalance;
    @Column
    private String accountOpenDate;


}
