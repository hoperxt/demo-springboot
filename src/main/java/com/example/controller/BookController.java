package com.example.controller;

import com.example.dao.BookDao;
import com.example.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao dao;

    @GetMapping("/list")
    public List<Book> getList() {
        return dao.findAll();
    }

    @PostMapping("/add")
    public Book addBook(@Valid Book vo, BindingResult result) {
        if (result.hasErrors()) {//返回对vo的验证结果
            System.out.println(result.getFieldError().getDefaultMessage());
            return null;
        }
        return dao.save(vo);
    }

    @GetMapping("/get/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return dao.findOne(id);
    }

    @GetMapping("/get/name/{name}")
    public List<Book> findBook(@PathVariable("name") String name) {
        return dao.findByName(name);
    }

    @PutMapping("/update/{id}")
    public Book update(@Valid Book vo, @PathVariable("id") Integer id, BindingResult result) {
        if (result.hasErrors()) {//返回对vo的验证结果
            System.out.println(result.getFieldError().getDefaultMessage());
            return null;
        }
        vo.setId(id);
        return dao.save(vo);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        dao.delete(id);
    }
}
