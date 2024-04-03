package com.jayesh.touristwebproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.touristwebproject.DTO.UserDTO;
import com.jayesh.touristwebproject.Service.UserService;

@RestController
@RequestMapping( "/user" )
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public String createUser(@ModelAttribute UserDTO userDTO){
       // userDTO.setUserId(userService.generateUserId()); 
       System.out.println(userDTO.getPassword());
       UserDTO user=userService.createUser(userDTO);
        System.out.println(user.getPassword());
        return "index.html";
    }
}
