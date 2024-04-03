package com.jayesh.touristwebproject.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayesh.touristwebproject.DTO.UserDTO;
import com.jayesh.touristwebproject.Entity.User;
import com.jayesh.touristwebproject.Mapper.UserMapper;
import com.jayesh.touristwebproject.Repository.UserRepository;
import com.jayesh.touristwebproject.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user=userMapper.mapUser(userDTO);
        User userCreated=userRepository.save(user);
        return userMapper.mapUserDTO(userCreated);
    }

}
