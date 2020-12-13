package com.example.demo.config;

import com.example.demo.services.GenreService;
import com.example.demo.services.GenreServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    GenreService getGenreService(){
        return new GenreServiceImpl();
    }
}
