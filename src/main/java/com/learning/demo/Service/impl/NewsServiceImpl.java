package com.learning.demo.Service.impl;

import com.learning.demo.Service.NewsService;
import com.learning.demo.model.News;
import com.learning.demo.repositroy.NewsReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsReporsitory newsReporsitory;

    @Override
    public List<News> findAll() {
        return newsReporsitory.findAll();
    }

    @Override
    public News save(News news) {
        return newsReporsitory.save(news);
    }
}
