package com.anderson.automation.webboka.infra;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anderson.automation.webboka.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
