package com.learning.demo.repositroy;

import com.learning.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserReporsitory extends JpaRepository<User, String>{

    User save(User user);
    User findByUsername(String name);
    List<User> findAll();

}
