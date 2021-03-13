package com.eventz.Eventz.converter;

import com.eventz.Eventz.dto.UserDTO;
import com.eventz.Eventz.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO modelToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> modelToDto(List<User> userList) {
        return userList.stream().map(this::modelToDto).collect(Collectors.toList());
    }

    public Set<UserDTO> modelToDto(Set<User> userList) {
        return userList.stream().map(this::modelToDto).collect(Collectors.toSet());
    }

    public User dtoToModel(UserDTO userDto) {
        return modelMapper.map(userDto, User.class);
    }

}