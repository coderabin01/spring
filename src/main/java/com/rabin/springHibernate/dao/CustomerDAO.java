package com.rabin.springHibernate.dao;

import com.rabin.springHibernate.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerDAO extends JpaRepository<Customer ,Long>{
}
