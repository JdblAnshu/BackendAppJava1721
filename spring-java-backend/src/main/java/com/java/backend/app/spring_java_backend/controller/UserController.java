package com.java.backend.app.spring_java_backend.controller;

import com.java.backend.app.spring_java_backend.model.User;
import com.java.backend.app.spring_java_backend.model.Venue;
import com.java.backend.app.spring_java_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
    User userDtl = userService.registerUser(user);
    return new ResponseEntity<>(userDtl, HttpStatus.CREATED);
    }

    //TODO
    public void login(){}

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateDetails(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return  new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

}
