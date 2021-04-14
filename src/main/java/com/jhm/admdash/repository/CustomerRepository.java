package com.jhm.admdash.repository;

import org.springframework.data.repository.CrudRepository;

import com.jhm.admdash.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
