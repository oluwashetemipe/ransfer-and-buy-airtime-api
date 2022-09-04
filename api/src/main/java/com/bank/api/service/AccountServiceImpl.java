package com.bank.api.service;

import com.bank.api.data.model.Account;
import com.bank.api.data.model.Customer;
import com.bank.api.data.model.Transaction;
import com.bank.api.data.repositories.AccountRepository;
import com.bank.api.data.repositories.CostumerRepository;
import com.bank.api.data.repositories.TransactionRepository;
import com.bank.api.exception.AccountNotFoundException;
import com.bank.api.web.dto.BuyAirtimeRequest;
import com.bank.api.web.dto.DoTransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@org.springframework.stereotype.Service

public class AccountServiceImpl implements Service {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CostumerRepository costumerRepository;
    @Override
    public void buyAirtime(BuyAirtimeRequest buyAirtimeRequest) throws AccountNotFoundException {
        Optional<Account> accountOptional = accountRepository.findByAccountNumber(buyAirtimeRequest.getSourceAccount());
        if (accountOptional.isEmpty()){
            throw new AccountNotFoundException("Account not found");
        }
        Account account = accountOptional.get();
        if (account.getAccountBalance() > buyAirtimeRequest.getAmount()){
            account.setAccountBalance(account.getAccountBalance() - buyAirtimeRequest.getAmount());
            System.out.printf("The %s number %s has been credited with %d", buyAirtimeRequest.getNetworkProvider(),buyAirtimeRequest.getPhoneNumber(),buyAirtimeRequest.getAmount());
        }
    }

    @Override
    public HttpStatus doTransfer(DoTransferRequest doTransferRequest) {
        if (doTransferRequest.getSourceAccount().isEmpty()){
            throw new IllegalArgumentException("Account number is Empty");
        }
        Optional<Account> account = accountRepository.findByAccountNumber(doTransferRequest.getSourceAccount());
        if (account.isPresent()){
            Customer customer = costumerRepository.findByType(account.get().getCustomerId());
            Enum type = customer.getCustomerType();
            Date date = customer.getDateCreated();
           if ( account.get().getAccountBalance() > doTransferRequest.getAmount()){
               Transaction transaction = new Transaction();
               transactionRepository.save(transaction);
               return HttpStatus.OK;
           }

        }
        return HttpStatus.BAD_REQUEST;
    }
    private static void discount(Customer customer,Transaction transaction){
        if (customer.getCustomerType() == Customer.CostumerType.BUSINESS){
            if (transaction.getTransactionPerAccountCount() > 3 && transaction.getAmount() > 150000 ){
                transaction.setDiscountedAmount(0.27 * transaction.getAmount());
            }
        }

    }
}
