package com.jayesh.touristwebproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.touristwebproject.DTO.UserDTO;
import com.jayesh.touristwebproject.Service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        UserDTO userDTO=userService.createUser(user);
        return new ResponseEntity<UserDTO>(userDTO,HttpStatus.CREATED);
    }
}
