package com.learning.demo.Service;

import com.learning.demo.model.User;

public interface UserService{

    public User save(User user);
    public User findByName(String name);

}
