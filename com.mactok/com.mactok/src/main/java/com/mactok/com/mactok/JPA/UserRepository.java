package com.mactok.com.mactok.JPA;

import com.mactok.com.mactok.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {

}
