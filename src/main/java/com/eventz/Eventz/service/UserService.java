package com.eventz.Eventz.service;

import com.eventz.Eventz.exceptions.UserNotFoundException;
import com.eventz.Eventz.model.User;
import com.eventz.Eventz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public List<User> getAllUsers() {
        return UserRepository.findAll();
    }

    public User addUser(User user) {
        return UserRepository.save(user);
    }

    public void deleteUser(UUID id) {
        UserRepository.delete(getUserById(id));
    }

    public User getUserById(UUID id) {
        return UserRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException(id));
    }

    public User findByUsername(String username) {
        return UserRepository.findByUsername(username);
    }

    public Boolean existsByUsername(String username) {
        return UserRepository.existsByUsername(username);
    }

    public Boolean existsByEmail(String email) {
        return UserRepository.existsByEmail(email);
    }
}
