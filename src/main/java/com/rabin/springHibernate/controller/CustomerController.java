package com.rabin.springHibernate.controller;

import com.rabin.springHibernate.dao.CustomerDAO;
import com.rabin.springHibernate.dto.message.ApiResponseMessage;
import com.rabin.springHibernate.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerDAO.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable long id){
        return customerDAO.findById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponseMessage> saveCustomer(@RequestBody Customer customer){
     customerDAO.save(customer);
     ApiResponseMessage response = new ApiResponseMessage("User Added Successfully", "200");
     return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable long id, @RequestBody Customer customer){
        customer.setId(id);
        customerDAO.save(customer);
    }

}
