package com.mactok.com.mactok;

import com.mactok.com.mactok.PostService.POSTNew;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class postSeeding {
    List<POSTNew> posts = new ArrayList<>();

    public POSTNew getPosts(int id) {
        Predicate<?super POSTNew> predicate = posts1 -> posts1.getId() == id;
        return posts.stream().filter(predicate).findFirst().orElse(null);
    }
}
