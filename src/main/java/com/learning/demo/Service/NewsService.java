package com.learning.demo.Service;

import com.learning.demo.model.News;

import java.util.List;

public interface NewsService {

    List<News> findAll();
    News save(News news);
}
