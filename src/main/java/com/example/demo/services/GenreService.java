package com.example.demo.services;


import com.example.demo.model.Genre;
import org.springframework.stereotype.Service;

@Service
public interface GenreService {
    Iterable<Genre> findAll();
}
