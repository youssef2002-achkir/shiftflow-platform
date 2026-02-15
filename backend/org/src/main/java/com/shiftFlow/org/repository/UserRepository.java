package com.shiftFlow.org.repository;

import com.shiftFlow.org.user.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {

    Map<String, User> users = new HashMap<>();

    public UserRepository() {
        users.put("youssef@gmail.com", new User("youssef dev","youssef@gmail.com", "engineer" ));
        users.put("jhon@gmail.com", new User("jhon arch","jhon@gmail.com", "architect" ));
    }

    public Optional<User> findByEmail (String email) {
        return Optional.ofNullable(users.get(email));
    }

    public User save(User user) {
        users.put(user.getEmail(), user);
        return user;
    }


}
