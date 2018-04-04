package com.learning.demo.Service.impl;

import com.learning.demo.Service.RoleService;
import com.learning.demo.model.Role;
import com.learning.demo.repositroy.RoleRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepositroy roleRepositroy;

    @Override
    public Role findByName(String name) {
        return roleRepositroy.findByName(name);
    }
}
