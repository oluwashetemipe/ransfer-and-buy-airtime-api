package com.bank.api.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column
    private String customerName;
    @Column
    private CostumerType customerType;
    @Column
    private Date dateCreated;
    public enum CostumerType{RETAIL,BUSINESS}
}
