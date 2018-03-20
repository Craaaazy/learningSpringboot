package com.learning.demo.Service.impl;

import com.learning.demo.Service.UserService;
import com.learning.demo.model.User;
import com.learning.demo.repositroy.UserReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

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

    @Override
    public List<User> findAll() {
        return userReporsitory.findAll();
    }


}
