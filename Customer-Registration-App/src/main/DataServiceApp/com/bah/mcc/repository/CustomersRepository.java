package com.bah.mcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bah.mcc.domain.Customer;

@Repository
public interface CustomersRepository extends CrudRepository<Customer, Long> {

}
