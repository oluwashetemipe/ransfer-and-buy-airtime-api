package com.bank.api.service;

import com.bank.api.exception.AccountNotFoundException;
import com.bank.api.web.dto.BuyAirtimeRequest;
import com.bank.api.web.dto.DoTransferRequest;
import org.springframework.http.HttpStatus;

public interface Service {
    HttpStatus buyAirtime(BuyAirtimeRequest buyAirtimeRequest) throws AccountNotFoundException;
    HttpStatus doTransfer(DoTransferRequest doTransferRequest);
}
