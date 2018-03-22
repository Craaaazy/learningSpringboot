package com.learning.demo.repositroy;

import com.learning.demo.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsReporsitory extends JpaRepository<News, String>{

    News save(News news);
    News findNewsById(int id);
    List<News> findAll();
    void deleteById(int id);

}
