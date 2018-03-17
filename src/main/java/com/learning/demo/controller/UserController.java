package com.learning.demo.controller;


import com.learning.demo.Service.UserService;
import com.learning.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/register")
    public String getRegisterUser(){
        return "register";
    }


    @PostMapping(value = "/register")
    @ResponseBody
    public String postRegisterUser(@ModelAttribute User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println("error");
            return "register";
        }

        userService.save(user);

        return "login";
    }

    @GetMapping(value = "/login")
    public String Login(){

        return "login";

    }

    @PostMapping(value = "/login")
    public String Login(@ModelAttribute User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println("error");
            return "login";
        }

        User user_dao = userService.findByName(user.getName());

        if(user.getName().equals(user_dao.getName()) && user.getPassword().equals(user_dao.getPassword())){



            return "welcome";
        }

        return "login";
    }


}
