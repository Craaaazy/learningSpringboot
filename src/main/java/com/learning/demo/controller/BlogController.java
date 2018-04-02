package com.learning.demo.controller;

import com.learning.demo.Service.BlogService;
import com.learning.demo.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping(value = "/s")          //findAll
    public List<Blog> getBlog(){

        return blogService.findAll();
    }

    @PostMapping(value = "/s")      //addBlog
    public Blog postBlog(@RequestBody Map<String, String> map){

        Blog blog = new Blog(map.get("title"), map.get("content"));
        return blogService.save(blog);

    }

    @DeleteMapping(value = "/s/{title}")        //delete by title
    public void deleteBlog(@PathVariable String title){
        blogService.deleteByBtitle(title);
    }

    @GetMapping(value = "/s/{title}")          //findByTiitle
    public Blog getOneBlog(@PathVariable String title){
        return blogService.findBlogByBtitle(title);
    }


}
