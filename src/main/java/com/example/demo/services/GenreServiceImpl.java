package com.example.demo.services;

import com.example.demo.model.Genre;
import com.example.demo.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Override
    public Iterable<Genre> findAll() {
        return genreRepository.findAll();
    }
}
