package com.learning.demo.Service.impl;

import com.learning.demo.Service.BlogService;
import com.learning.demo.model.Blog;
import com.learning.demo.repositroy.BlogRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Blog findBlogByBtitle(String title) {
        return blogRepositroy.findBlogByBtitle(title);
    }

    @Override
    @Transactional
    @Modifying
    public void deleteByBtitle(String title) {
        blogRepositroy.deleteByBtitle(title);
    }


}
