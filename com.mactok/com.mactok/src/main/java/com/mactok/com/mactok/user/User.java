package com.mactok.com.mactok.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mactok.com.mactok.PostService.POSTNew;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Size(min=2, message="Minimum two character require")
    private String name;
    @Past(message = "Date must be in past")
    private LocalDate birthdate;

    public List<POSTNew> getPost() {
        return post;
    }

    public void setPost(List<POSTNew> post) {
        this.post = post;
    }

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<POSTNew> post;

protected User(){

}
    public User(int id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
