package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Optional;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/authenticate")
    public User authenticate(Principal principal){
        log.info("authenticate");
        try{
            log.info(principal.getName());
            AuthenticationBean bean = new AuthenticationBean(principal.getName());
            if(bean.getUsername() != null){
                Optional<User> optionalUser = userRepository.findByUsername(principal.getName());
                return optionalUser.get();
            }else{
                return null;
            }
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
