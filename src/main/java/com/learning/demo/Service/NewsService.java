package com.learning.demo.Service;

import com.learning.demo.model.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {

    List<News> findAll();
    News save(News news);
    News findNewsById(int id);
    void deleteById(int id);

}
