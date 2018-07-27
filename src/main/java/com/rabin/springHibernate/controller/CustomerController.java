package com.rabin.springHibernate.controller;

import com.rabin.springHibernate.dao.CustomerDAO;
import com.rabin.springHibernate.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping
    public List<Customer> getCustomer(){
        return null;
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){
      return customerDAO.save(customer);
    }
}
