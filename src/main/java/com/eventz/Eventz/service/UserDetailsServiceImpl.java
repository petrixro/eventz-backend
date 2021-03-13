package com.eventz.Eventz.service;

import com.eventz.Eventz.model.User;
import com.eventz.Eventz.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {

        User user = userService.findByUsername(username);
            return UserDetailsImpl.buildUser(user);


    }
}
