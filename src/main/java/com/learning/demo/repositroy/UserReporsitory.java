package com.learning.demo.repositroy;

import com.learning.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReporsitory extends JpaRepository<User, String>{

    public User save(User user);
    public User findByName(String name);

}
