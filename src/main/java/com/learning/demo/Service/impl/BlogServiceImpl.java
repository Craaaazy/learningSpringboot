package com.learning.demo.Service.impl;

import com.learning.demo.Service.BlogService;
import com.learning.demo.model.Blog;
import com.learning.demo.repositroy.BlogRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepositroy blogRepositroy;

    @Override
    public Blog save(Blog blog) {
        return blogRepositroy.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepositroy.findAll();
    }
}
