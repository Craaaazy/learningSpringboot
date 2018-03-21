package com.learning.demo.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {


    @GetMapping(value = "/news")
    public void show_news(){

    }

    @PostMapping(value = "/news")
    public void add_news(){

    }

    @DeleteMapping(value = "/news")
    public void delete_news(){

    }


}
