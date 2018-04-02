package com.learning.demo.Service;

import com.learning.demo.model.Blog;

import java.util.List;

public interface BlogService {
    Blog save(Blog blog);
    List<Blog> findAll();
    Blog findBlogByBtitle(String title);
    void deleteByBtitle(String title);
}
