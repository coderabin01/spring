package com.rabin.springHibernate.service;

import com.rabin.springHibernate.dto.ApiResponseMessage;
import com.rabin.springHibernate.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAllCustomer();

    Optional<Customer> retrieveCustomer(Long id);

    public void addCustomer(Customer customer);

//    public void updateCustomer(Customer customer);

    public void deleteCustomer(Long id);
}
