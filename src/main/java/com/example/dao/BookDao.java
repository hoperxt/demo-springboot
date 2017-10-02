package com.example.dao;

import com.example.vo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

    //方法名必须遵循这种格式
    List<Book> findByName(String name);
}
