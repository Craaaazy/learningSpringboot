package com.learning.demo.controller;


import com.learning.demo.Service.NewsService;
import com.learning.demo.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/my")
public class NewsController {

    @Autowired
    NewsService newsService;


    @GetMapping(value = "/news")  //查询全部
    public List<News> show_news(){
        System.out.println("in get");

        List<News> list = newsService.findAll();

        return list;
    }


    @GetMapping(value = "/news/{id}")  //按id查询
    public News show_news(@PathVariable int id){
        System.out.println("in get{id}" + id);

        return newsService.findNewsById(id);
    }


    @PostMapping(value = "/news") //新增一条
    public News add_news(@RequestParam("title") String title, @RequestParam("content") String content){

        News news = new News();
        news.setTitle(title);
        news.setContent(content);

        return newsService.save(news);

    }


    @DeleteMapping(value = "/news") //删除一条
    public void delete_news(@RequestParam("id") int id){

        System.out.println("in delete");

        newsService.deleteById(id);
    }


    @PutMapping(value = "/news") //修改一条
    public void put_news(){
        System.out.println("in put");

    }


}
