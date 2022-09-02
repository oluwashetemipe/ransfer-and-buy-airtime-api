package com.bank.api.web.dto;

import lombok.Data;

@Data
public class DoTransferRequest {
    private String sourceAccount;
    private String destinationAccount;
    private double amount;

}
