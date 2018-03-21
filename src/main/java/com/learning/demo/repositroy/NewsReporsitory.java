package com.learning.demo.repositroy;

import com.learning.demo.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsReporsitory extends JpaRepository<News, String>{

    News save(News news);
    List<News> findAll();

}
