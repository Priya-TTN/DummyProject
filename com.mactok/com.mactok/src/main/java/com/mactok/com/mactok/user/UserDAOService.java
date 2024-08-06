package com.mactok.com.mactok.user;


// DAO - Data Access Object
// I want that sprint will have to manage this that's why i use @component

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
     // we are going to use JPA / hibernate to talk to the Data base
    // crete static array list - hybernet talk to this list
    public static List<User> users = new ArrayList<>();
    private static int userCount = 0;
    // created a static block and initizes all the users
    static{

        users.add(new User(++userCount, "Priya", LocalDate.now().minusYears(26)));
        users.add(new User(++userCount, "Naina", LocalDate.now().minusYears(21)));
        users.add(new User(++userCount, "Mina", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount, "Mocha", LocalDate.now().minusYears(25)));
    }
    // what all methods we have to perform in this are -

    public List<User> AllUsers(){
        return users;
    }

    public User saveUser(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
    public User Userdetail(int id) {

        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void DeleteUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }
    // to be able to retrive all the users
    // to be able to save the users
    // to be able to find the specific details of a user
}
