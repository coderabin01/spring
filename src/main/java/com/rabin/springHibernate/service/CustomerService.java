package com.rabin.springHibernate.service;

import com.rabin.springHibernate.dto.ApiResponseMessage;
import com.rabin.springHibernate.dto.CustomerRequestDTO;
import com.rabin.springHibernate.dto.CustomerRequestDTOList;
import com.rabin.springHibernate.model.Customer;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    CustomerRequestDTOList getAllCustomer(Pageable pageable);

    Optional<Customer> retrieveCustomer(Long id);

    Customer addCustomer(CustomerRequestDTO customerRequestDTO);

//    public void updateCustomer(Customer customer);

    public void deleteCustomer(Long id);
}
