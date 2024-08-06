package com.mactok.com.mactok.user;


import com.mactok.com.mactok.JPA.UserRepository;
import com.mactok.com.mactok.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class UserJPAResource {
    //1. REST service we have to retrive all the users

    private UserRepository repository;
    public UserJPAResource(UserRepository repository ){


        this.repository = repository;
    }
    @GetMapping("/jpa/users")
    public List<User> RetriveAllUser(){

        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public Optional<User> RetriveUserDetail(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if(user ==null){
            throw new UserNotFoundException("id :"+id);
        }
        return repository.findById(id);
    }

    @DeleteMapping("/jpa/users/{id}")
    public void DeleteUser(@PathVariable int id){

        repository.deleteById(id);
    }

    // create a new user
    // POSt  - > /users


    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        // how to send back the URI with status code once success
        // set the path - > / user then get the id/ then give the id
//        throw new RuntimeException("Test");
        User savedId = repository.save(user);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedId.getId())
                    .toUri();
        repository.save(user);
        //how to change the status code
       return ResponseEntity.created(location).build();
    }
}
