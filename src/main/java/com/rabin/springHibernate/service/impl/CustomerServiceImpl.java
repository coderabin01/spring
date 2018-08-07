package com.rabin.springHibernate.service.impl;

import com.rabin.springHibernate.model.Customer;
import com.rabin.springHibernate.repository.CustomerRepository;
import com.rabin.springHibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> retrieveCustomer(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    @Override
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }


}
