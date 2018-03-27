package com.learning.demo.controller;

import com.learning.demo.Service.NewsService;
import com.learning.demo.Service.UserService;
import com.learning.demo.model.News;
import com.learning.demo.model.User;
import com.learning.demo.repositroy.NewsReporsitory;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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


    @GetMapping(value = "/myNews")
    public String showdd(){
        return "myNews";
    }

    @GetMapping(value = "/myBlog")
    public String showBlog(){
        return "myBlog";
    }

}
