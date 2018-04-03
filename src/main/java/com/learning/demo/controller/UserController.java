package com.learning.demo.controller;

import com.learning.demo.Service.NewsService;
import com.learning.demo.Service.UserService;
import com.learning.demo.model.News;
import com.learning.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    NewsService newsService;

    @GetMapping(value = "/register")
    public String getRegisterUser(){
        return "register";
    }


    @PostMapping(value = "/register")
    public String postRegisterUser(@ModelAttribute User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println("error");
            return "register";
        }

        userService.save(user);
        System.out.println(user.getName() + "   " + user.getPassword());

        return "login";
    }

    @GetMapping(value = "/")
    public String wel(){
        return "welcome";
    }


//    @GetMapping(value = "/login")
//    public String Login(/*ModelMap modelMap*/){
//
//        User newuser = new User();
//        newuser.setName("user");
//        newuser.setPassword("password");
//        ModelMap.addAttribute("newuser", newuser);
//
//        return "login";
//    }

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
