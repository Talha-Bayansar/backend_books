package com.example.demo.controllers;

import com.example.demo.model.Genre;
import com.example.demo.repositories.GenreRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @CrossOrigin
    @ApiOperation(value = "Find all the genres that are stored in the database.")
    @GetMapping("/genres")
    public Iterable<Genre> findAll(){
        return genreRepository.findAll();
    }
}
