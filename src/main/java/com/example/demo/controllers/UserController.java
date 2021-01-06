package com.example.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@RestController
@Slf4j
public class UserController {

    @GetMapping("/authenticate")
    public AuthenticationBean authenticate(Principal principal){
        log.info("authenticate");
        try{
            return new AuthenticationBean(principal.getName());
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to login");
        }
    }

    @Data
    @AllArgsConstructor
    class AuthenticationBean {
        private String username;
    }
}
