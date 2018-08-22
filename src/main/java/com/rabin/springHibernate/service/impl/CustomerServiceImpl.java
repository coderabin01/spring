package com.rabin.springHibernate.service.impl;

import com.rabin.springHibernate.dto.CustomerRequestDTO;
import com.rabin.springHibernate.dto.CustomerRequestDTOList;
import com.rabin.springHibernate.model.Customer;
import com.rabin.springHibernate.repository.CustomerRepository;
import com.rabin.springHibernate.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerRequestDTOList getAllCustomer(Pageable pageable){
        logger.info("getAllCustomer(): START");
        List<CustomerRequestDTO> customers;
        long customerCount = customerRepository.count();
        customers = customerRepository.findAll(pageable).getContent().stream().map(CustomerRequestDTO::new).collect(Collectors.toList());
        return new CustomerRequestDTOList(customerCount, customers);
    }

    @Override
    public Optional<Customer> retrieveCustomer(Long id) {
        logger.info(String.format("retrieveCustomer(): with id %d", id));
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomer(Long id){
        logger.info("deleteCustomer(): START");
        customerRepository.deleteById(id);
    }

    @Override
    public Customer addCustomer(CustomerRequestDTO customerRequestDTO){
        logger.info("addCustomer(): START");
        Customer customer = new Customer(customerRequestDTO.getId(),customerRequestDTO.getName(), customerRequestDTO.getEmail());
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer;
    }


}
