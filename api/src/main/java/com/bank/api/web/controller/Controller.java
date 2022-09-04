package com.bank.api.web.controller;

import com.bank.api.service.AccountServiceImpl;
import com.bank.api.web.dto.BuyAirtimeRequest;
import com.bank.api.web.dto.DoTransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class Controller {
    @Autowired
    AccountServiceImpl accountService;

    @PostMapping("/do-transfer")
    public ResponseEntity<?> DoTransfer(@RequestBody DoTransferRequest transferRequest) {
        try {
            //entry point
            return new ResponseEntity<>(accountService.doTransfer(transferRequest), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/buy-airtime")
    public ResponseEntity<?> BuyAirtime(@RequestBody BuyAirtimeRequest buyAirtimeRequest) {
        try {
            return new ResponseEntity<>(accountService.buyAirtime(buyAirtimeRequest), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
