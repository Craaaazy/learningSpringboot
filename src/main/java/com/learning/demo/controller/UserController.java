package com.learning.demo.controller;

import com.learning.demo.Service.NewsService;
import com.learning.demo.Service.RoleService;
import com.learning.demo.Service.UserService;
import com.learning.demo.model.News;
import com.learning.demo.model.Role;
import com.learning.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    NewsService newsService;
    @Autowired
    RoleService roleService;

    Role role = null;
    User user = null;

    @GetMapping(value = "/register")
    public String getRegisterUser(){
        return "register";
    }


    @PostMapping(value = "/register") //Requestparam从form里面拿值
    public String postRegisterUser(@RequestParam Map<String, String> map){

        role = roleService.findByName(map.get("role"));

        System.out.println(role);

        user = new User();
        user.setUsername(map.get("username"));
        user.setPassword(map.get("password"));
        user.setRole(role);
        user.setEnable(true);

        userService.save(user);

        return "login";
    }

    @GetMapping(value = "/")
    public String wel(){
        return "welcome";
    }

    @GetMapping(value = "/user/profile")   //不知道springsecurity里登录的信息保存在什么里面
    public String user_profile(){
        ModelMap modelMap = new ModelMap();

        return "user_profile";
    }


    @GetMapping(value = "/shownews")
    public String showAll_News(){
        return "/all_News";
    }


    @ResponseBody
    @PostMapping(value = "/shownews")
    public News the_news(){
        News news = new News();
        news.setTitle("ChinaDaily");
        news.setContent("今日无事");

        return news;
    }

    @GetMapping(value = "/myBlog")
    public String byBlog(){
        return "myBlog";
    }

    @GetMapping(value = "/showBlog")
    public String showBlog(){
        return "showBlog";
    }

}
