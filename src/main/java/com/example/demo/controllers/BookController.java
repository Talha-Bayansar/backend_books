package com.example.demo.controllers;

import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.Thread.sleep;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    private Logger logger = LoggerFactory.getLogger(BookController.class);

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

    @CrossOrigin
    @DeleteMapping("/books/{id}")
    public Iterable<Book> delete(@PathVariable int id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            bookRepository.delete(optionalBook.get());
        }
        Iterable<Book> books = bookRepository.findAll();
        return books;
    }

    @CrossOrigin
    @PutMapping("/books")
    public Iterable<Book> edit(@RequestBody Book book){
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        logger.info(book.getId() + " " + book.getTitle());
        if(optionalBook.isPresent()){
            Book b = optionalBook.get();
            logger.info(b.getId() + " " + b.getTitle());
            b.setTitle(book.getTitle());
            b.setAuthor(book.getTitle());
            b.setSells(book.getSells());
            bookRepository.save(b);
            logger.info(b.getId() + " " + b.getTitle());
        }
        return bookRepository.findAll();
    }
}
