package com.rabin.springHibernate.controller;

import com.rabin.springHibernate.dto.ApiResponseMessage;
import com.rabin.springHibernate.exception.CustomerNotFoundException;
import com.rabin.springHibernate.model.Customer;
import com.rabin.springHibernate.service.CustomerService;
import com.rabin.springHibernate.utils.ApiResponeMessageUtil;
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
    CustomerService customerService;

    @Autowired
    ApiResponeMessageUtil apiResponseMessageUtil;

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable long id) {
        return customerService.retrieveCustomer(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponseMessage> addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        ApiResponseMessage response = apiResponseMessageUtil.getApiResponseMessage("3001");
        return new ResponseEntity<ApiResponseMessage>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseMessage> updateCustomer(@RequestBody Customer customer, @PathVariable long id){
        Optional<Customer> customerToRemove = customerService.retrieveCustomer(id);
        if(!customerToRemove.isPresent()){
            throw new CustomerNotFoundException("Customer with id - "+id+" is not found");
        }
        customer.setId(id);
        customerService.addCustomer(customer);
        ApiResponseMessage response = apiResponseMessageUtil.getApiResponseMessage("3002");
        return new ResponseEntity<ApiResponseMessage>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseMessage> deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
        ApiResponseMessage response = apiResponseMessageUtil.getApiResponseMessage("3003");
        return new ResponseEntity<ApiResponseMessage>(response, HttpStatus.OK);
    }

}
