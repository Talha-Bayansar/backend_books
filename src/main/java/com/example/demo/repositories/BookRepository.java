package com.example.demo.repositories;

import com.example.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Iterable<Book> findByTitleContains(String subString);
    Optional<Book> findByTitle(String title);
}
