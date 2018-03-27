package com.learning.demo.controller;

import com.learning.demo.Service.BlogService;
import com.learning.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller(value = "/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping(value = "/s")
    public List<Blog> getBlog(){

        return blogService.findAll();

    }

    @PostMapping(value = "/s")
    @ResponseBody
    public Blog postBlog(@ModelAttribute Blog blog){

        System.out.println(blog);
        return blogService.save(blog);

    }

}
