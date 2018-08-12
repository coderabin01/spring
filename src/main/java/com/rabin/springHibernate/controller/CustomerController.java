package com.rabin.springHibernate.controller;

import com.rabin.springHibernate.dto.ApiResponseMessage;
import com.rabin.springHibernate.dto.CustomerRequestDTO;
import com.rabin.springHibernate.dto.CustomerRequestDTOList;
import com.rabin.springHibernate.exception.CustomerNotFoundException;
import com.rabin.springHibernate.model.Customer;
import com.rabin.springHibernate.service.CustomerService;
import com.rabin.springHibernate.utils.ApiResponeMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<CustomerRequestDTOList> getAllCustomer(@PageableDefault(sort ="id", direction = Sort.Direction.DESC) Pageable pageable){
        CustomerRequestDTOList customerRequestDTOList = customerService.getAllCustomer(pageable);
        return new ResponseEntity<CustomerRequestDTOList>(customerRequestDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable long id) {
        return customerService.retrieveCustomer(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponseMessage> addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerService.addCustomer(customerRequestDTO);
        ApiResponseMessage response = apiResponseMessageUtil.getApiResponseMessage("3001");
        return new ResponseEntity<ApiResponseMessage>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseMessage> updateCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO, @PathVariable long id){
        Optional<Customer> customerToRemove = customerService.retrieveCustomer(id);
        if(!customerToRemove.isPresent()){
            throw new CustomerNotFoundException("Customer with id - "+id+" is not found");
        }
        customerRequestDTO.setId(id);
        customerService.addCustomer(customerRequestDTO);
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
