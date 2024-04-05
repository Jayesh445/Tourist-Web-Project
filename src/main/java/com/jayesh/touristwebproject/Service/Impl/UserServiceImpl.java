package com.jayesh.touristwebproject.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayesh.touristwebproject.DTO.UserDTO;
import com.jayesh.touristwebproject.Entity.User;
import com.jayesh.touristwebproject.Exception.ResourceNotFoundException;
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

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long userId) {
        User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userid", userId));
                user.setEmail(userDTO.getEmail());
                user.setPassword(userDTO.getPassword());
                user.setFName(userDTO.getFName());
                user.setLName(userDTO.getLName());
                user.setAddress(userDTO.getAddress());
                user.setDOB(userDTO.getDOB());
                user.setPhoneNo(userDTO.getPhoneNo());
                User updatedUser = this.userRepository.save(user);
        
                return  userMapper.mapUserDTO(updatedUser);
    }

    @Override
    public UserDTO getUserByEmailAndPassword(String email, String password) {
        User user = this.userRepository.findByEmailAndPassword(email, password).orElseThrow(()-> new ResourceNotFoundException("User", "email", email));
        return userMapper.mapUserDTO(user);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userid", userId));
        return userMapper.mapUserDTO(user);
    }

}
