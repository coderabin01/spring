package com.rabin.springHibernate.repository;

import com.rabin.springHibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserDAO extends JpaRepository<User ,Long>{

}
