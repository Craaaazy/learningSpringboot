package com.learning.demo.Service;

import com.learning.demo.model.User;

import java.util.List;

public interface UserService{

    public User save(User user);
    public User findByName(String name);
    public List<User> findAll();

}
