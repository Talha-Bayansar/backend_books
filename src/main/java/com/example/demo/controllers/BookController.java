package com.example.demo.controllers;

import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    @ApiOperation(value = "Find all the books that are stored in the database.")
    @GetMapping("/books")
    public Iterable<Book> findAll(@RequestParam(required = false) String titleKeyWord) {
        Iterable<Book> books = bookRepository.findAll();
        if(titleKeyWord != null){
            books = bookRepository.findByTitleContains(titleKeyWord);
        }
        return books;
    }

    @CrossOrigin
    @ApiOperation(value = "Add a new book in the database.")
    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        if(bookRepository.findByTitle(book.getTitle()).isPresent())
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    String.format("Book with title %s already exists.", book.getTitle()));
        return bookRepository.save(book);
    }

    @CrossOrigin
    @ApiOperation(value = "Delete a book from the database.")
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
    @ApiOperation(value = "Edit an existing book from the database.")
    @PutMapping("/books/{id}")
    public Iterable<Book> edit(@PathVariable int id, @RequestBody Book book){
        Optional<Book> optionalBook = bookRepository.findById(id);
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
