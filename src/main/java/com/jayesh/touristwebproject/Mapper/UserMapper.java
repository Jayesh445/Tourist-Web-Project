package com.jayesh.touristwebproject.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jayesh.touristwebproject.DTO.UserDTO;
import com.jayesh.touristwebproject.Entity.User;

@Component
public class UserMapper {

    @Autowired
    ModelMapper modelmapper;

    public  UserDTO mapUserDTO(User user){
        return modelmapper.map(user, UserDTO.class);
    }
    public User mapUser(UserDTO userDTO){
        return modelmapper.map(userDTO,User.class);
    }
}
