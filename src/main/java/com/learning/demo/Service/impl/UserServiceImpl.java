package com.learning.demo.Service.impl;

import com.learning.demo.Service.UserService;
import com.learning.demo.model.User;
import com.learning.demo.repositroy.UserReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserReporsitory userReporsitory;

    @Override
    public User save(User user) {
        return userReporsitory.save(user);
    }

    @Override
    public User findByName(String name) {
        return userReporsitory.findByName(name);
    }

}
