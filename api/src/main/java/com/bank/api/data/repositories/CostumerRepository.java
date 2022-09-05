package com.bank.api.data.repositories;

import com.bank.api.data.model.Customer;

public interface CostumerRepository {
    Customer findById(Long id);
}
