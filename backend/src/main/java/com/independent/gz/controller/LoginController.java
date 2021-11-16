package com.independent.gz.controller;

import com.independent.gz.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> test() {


        User user = new User();
        user.setFirstName("scott");
        user.setLastName("Li");
        user.setPassword("888888888888888");

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
