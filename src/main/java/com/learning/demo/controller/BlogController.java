package com.learning.demo.controller;

import com.learning.demo.Service.BlogService;
import com.learning.demo.Service.UserService;
import com.learning.demo.model.Blog;
import com.learning.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;

    @GetMapping(value = "/s")          //findAll
    public List<Blog> getBlog(){
        return blogService.findAll();
    }

    @PostMapping(value = "/s")      //addBlog
    public Blog postBlog(Principal principal, @RequestBody Map<String, String> map){

        System.out.println("---post blog---");
        User user = userService.findByUsername(principal.getName());
        Blog blog = new Blog(map.get("title"), map.get("content"), user);
        return blogService.save(blog);

    }

    @DeleteMapping(value = "/s/{title}")        //delete by title pathVariable是从url里拿值
    public void deleteBlog(@PathVariable String title, Principal principal){

        System.out.println("---delete---");

        String username = principal.getName();

        System.out.println(username);

        Blog blog = blogService.findBlogByBtitle(title);

        if(blog.getUser().getUsername().equals(username)){
            blogService.deleteByBtitle(title);
        }else{
            System.out.println("error:不是该用户");
        }

    }

    @GetMapping(value = "/s/{title}")          //findByTiitle
    public Blog getOneBlog(@PathVariable String title){
        return blogService.findBlogByBtitle(title);
    }

    @PutMapping(value = "/s")                   //update by title
    public void putOneBlog(@RequestBody Map<String, String> map){ // RequestBody 返回josn
    }

}
