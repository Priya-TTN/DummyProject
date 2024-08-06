package com.mactok.com.mactok.user;


import com.mactok.com.mactok.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class UserResource {
    //1. REST service we have to retrive all the users
    private  UserDAOService service;
    public UserResource(UserDAOService service){
        this.service = service;
    }
    @GetMapping("/users")
    public List<User> RetriveAllUser(){
        return service.AllUsers();
    }

    @GetMapping("/users/{id}")
    public User RetriveUserDetail(@PathVariable int id){
        User user = service.Userdetail(id);
        if(user ==null){
            throw new UserNotFoundException("id :"+id);
        }
        return service.Userdetail(id);
    }

    @DeleteMapping("/users/{id}")
    public void DeleteUser(@PathVariable int id){
        service.DeleteUserById(id);
    }

    // create a new user
    // POSt  - > /users


    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        // how to send back the URI with status code once success
        // set the path - > / user then get the id/ then give the id
        throw new RuntimeException("Test");
//        User savedId = service.saveUser(user);
//
//            URI location = ServletUriComponentsBuilder
//                    .fromCurrentRequest()
//                    .path("/{id}")
//                    .buildAndExpand(savedId.getId())
//                    .toUri();
//        service.saveUser(user);
//        //how to change the status code
//       return ResponseEntity.created(location).build();
    }
}
