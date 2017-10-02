package com.example.controller;


import com.example.properties.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private BookProperties book;

    @RequestMapping(value = "/demo")
    public String demo() {
        return book.getName() + "," + book.getPrice();
    }
}
