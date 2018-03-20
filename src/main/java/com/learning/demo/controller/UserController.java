package com.learning.demo.controller;


import com.learning.demo.Service.UserService;
import com.learning.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserService userService;

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

        return "login";
    }

    @GetMapping(value = "/")
    public String getWel(){
        return "welcome";
    }

//    @PostMapping(value = "/login")
//    public String pLogin(HttpServletRequest request) throws Exception {
//        String username = request.getParameter("name");
//        String password = request.getParameter("password");
//
//        User checkedUser = userService.findByName(username);
//
//        if(checkedUser == null){
//            throw new Exception("没有");
//        }
//
//        if(checkedUser.getPassword().equals(password)){
//            return "welcome";
//        }else{
//            return "login";
//        }
//    }

}
