package com.learning.demo.Service.impl;

import com.learning.demo.Service.NewsService;
import com.learning.demo.model.News;
import com.learning.demo.repositroy.NewsReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public News findNewsById(int id) {
        return newsReporsitory.findNewsById(id);
    }

    @Override
    @Transactional
    @Modifying
    public void deleteById(int id) {
        newsReporsitory.deleteById(id);
    }
}
