package com.learning.demo.Service;

import com.learning.demo.model.User;

import java.util.List;

public interface UserService{

    User save(User user);
    User findByUsername(String name);
    List<User> findAll();

}
