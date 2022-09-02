package com.bank.api.web.dto;

import lombok.Data;

@Data
public class BuyAirtimeRequest {
    private String sourceAccount;
    private String networkProvider;
    private int amount;
    private String phoneNumber;
}
