package com.mactok.com.mactok.PostController;


import com.mactok.com.mactok.JPA.UserRepository;
import com.mactok.com.mactok.PostService.POSTNew;
import com.mactok.com.mactok.exception.UserNotFoundException;
import com.mactok.com.mactok.postSeeding;
import com.mactok.com.mactok.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


public class POSTN {
    private UserRepository repository;
private postSeeding postseed;
    @GetMapping("/users/{id}/posts")
    public List<POSTNew> getPOST(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id"+id);
        }

     return user.get().getPost();
    }

//    @PostMapping
//    public void createNewPost(@)
}
