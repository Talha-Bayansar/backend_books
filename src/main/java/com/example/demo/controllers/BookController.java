package com.example.demo.controllers;

import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @CrossOrigin
    @GetMapping("/books")
    public Iterable<Book> findAll() {
        Iterable<Book> books = bookRepository.findAll();
        return books;
    }

    @CrossOrigin
    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return bookRepository.save(book);
    }
}
