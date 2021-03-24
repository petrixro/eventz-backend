package com.eventz.Eventz.controller;

import com.eventz.Eventz.converter.UserConverter;
import com.eventz.Eventz.dto.UserDTO;
import com.eventz.Eventz.model.User;
import com.eventz.Eventz.model.UserRole;
import com.eventz.Eventz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "https://eventz-app.herokuapp.com/")
public class UserController {

    @Autowired
    private  UserConverter userConverter;

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return userConverter.modelToDto(users);
    }

    @PostMapping("/users")
    public UserDTO addUser(@RequestBody UserDTO newUser){
        User user = userConverter.dtoToModel(newUser);
        return userConverter.modelToDto(userService.addUser(user));
    }

    @GetMapping("users/{id}")
    public UserDTO getUserByID(@PathVariable UUID id){
        User user = userService.getUserById(id);
        return userConverter.modelToDto(user);
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
}
