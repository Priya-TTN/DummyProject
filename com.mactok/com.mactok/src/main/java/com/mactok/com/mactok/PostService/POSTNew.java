package com.mactok.com.mactok.PostService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mactok.com.mactok.user.User;
import jakarta.persistence.*;

@Entity
public class POSTNew {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
    private String description;

    public POSTNew(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "POSTNew{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
