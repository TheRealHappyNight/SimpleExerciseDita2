package com.example.demo.controllers;

import com.example.demo.dtos.UserDTO;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        this.userService.createUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDTO userDTO) {
        this.userService.updateUser(userDTO);
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable String id) {
        return this.userService.getUser(Integer.valueOf(id));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable String id) {
        this.userService.deleteUser(Integer.valueOf(id));
    }
}
