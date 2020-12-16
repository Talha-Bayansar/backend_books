package com.example.demo.controllers;

import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Slf4j
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @ApiOperation(value = "Find all the books that are stored in the database.")
    @GetMapping("/books")
    public Iterable<Book> findAll(@RequestParam(required = false) String titleKeyWord) {
        log.info("--------findAll---------");
        Iterable<Book> books = bookRepository.findAll();
        if(titleKeyWord != null){
            books = bookRepository.findByTitleContains(titleKeyWord);
        }
        return books;
    }

    @ApiOperation(value = "Add a new book in the database.")
    @PostMapping("/books")
    public Book create(@Valid @RequestBody Book book){
        log.info("--------create---------");
        if(bookRepository.findByTitle(book.getTitle()).isPresent())
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    String.format("Book with title %s already exists.", book.getTitle()));
        try {
            bookRepository.save(book);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Server didn't respond correctly.");
        }
        return book;
    }

    @ApiOperation(value = "Delete a book from the database.")
    @DeleteMapping("/books/{id}")
    public Iterable<Book> delete(@PathVariable int id){
        log.info("--------delete---------");
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            bookRepository.delete(optionalBook.get());
        }else{
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "The book you tried to delete doesn't exist.");
        }
        Iterable<Book> books = bookRepository.findAll();
        return books;
    }

    @ApiOperation(value = "Edit an existing book from the database.")
    @PutMapping("/books/{id}")
    public Iterable<Book> edit(@PathVariable int id, @Valid @RequestBody Book book){
        log.info("--------edit---------");
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            Book b = optionalBook.get();
            log.info(b.getId() + " " + b.getTitle());
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
            b.setPriceInEuro(book.getPriceInEuro());
            bookRepository.save(b);
            log.info(b.getId() + " " + b.getTitle());
        }else{
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "The book you tried to edit doesn't exist.");
        }
        return bookRepository.findAll();
    }

    @GetMapping("/authenticate")
    public AuthenticationBean authenticate(Principal principal){
        log.info("authenticate");
        return new AuthenticationBean(principal.getName());
    }

    @Data
    @AllArgsConstructor
    class AuthenticationBean {
        private String username;
    }
}
