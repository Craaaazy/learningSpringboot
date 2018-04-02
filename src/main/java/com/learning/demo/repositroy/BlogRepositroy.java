package com.learning.demo.repositroy;

import com.learning.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepositroy extends JpaRepository<Blog,String>{

    Blog save(Blog blog);
    List<Blog> findAll();
    Blog findBlogByBtitle(String title);
    void deleteByBtitle(String title);

}
