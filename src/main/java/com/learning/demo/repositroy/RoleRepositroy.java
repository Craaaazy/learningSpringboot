package com.learning.demo.repositroy;

import com.learning.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositroy extends JpaRepository<Role, String> {

    Role findByName(String name);
}
