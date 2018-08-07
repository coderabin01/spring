package com.rabin.springHibernate.controller;

import com.rabin.springHibernate.repository.UserDAO;
import com.rabin.springHibernate.dto.ApiResponseMessage;
import com.rabin.springHibernate.exception.StudentNotFoundException;
import com.rabin.springHibernate.model.User;
import com.rabin.springHibernate.utils.ApiResponeMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ApiResponeMessageUtil apiResponseMessageUtil;

    @GetMapping
    public List<User> getUser(){
        return userDAO.findAll();
    }

    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable long id){
        Optional<User> user = userDAO.findById(id);

        if(!user.isPresent()){
            throw new StudentNotFoundException("User with user_id-" + id + " not found");
        }
        return user.get();
    }

    @PostMapping
    public ResponseEntity<ApiResponseMessage> saveUser(@RequestBody User user){
        userDAO.save(user);
        ApiResponseMessage response = apiResponseMessageUtil.getApiResponseMessage("3000");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userDAO.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long id){
        Optional<User> userToRemove = userDAO.findById(id);
        if(!userToRemove.isPresent()){
            throw new StudentNotFoundException("User with id - "+ id +" is not found");
        }
        user.setId(id);
        userDAO.save(user);
        return ResponseEntity.noContent().build();
    }
}
