package com.bah.mcc.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.mcc.domain.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

}
