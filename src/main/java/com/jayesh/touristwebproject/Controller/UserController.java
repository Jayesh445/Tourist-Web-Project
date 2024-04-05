package com.jayesh.touristwebproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayesh.touristwebproject.DTO.UserDTO;
import com.jayesh.touristwebproject.DTO.UserLoginDTO;
import com.jayesh.touristwebproject.Service.UserService;

@Controller
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

    @PostMapping("/signIn")
	public ResponseEntity<UserDTO> authenticateCustomer(@ModelAttribute UserLoginDTO userdto)
	{
		UserDTO getUserByEmailAndPassword = this.userService.getUserByEmailAndPassword(userdto.getEmail(), userdto.getPassword());
	return ResponseEntity.ok(getUserByEmailAndPassword);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDTO> updateUser(@ModelAttribute UserDTO userdto, @PathVariable Long userId) {
		UserDTO updateUser = this.userService.updateUser(userdto, userId);
		return new ResponseEntity<UserDTO>(updateUser, HttpStatus.OK);
	}

	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
		UserDTO getUser = this.userService.getUserById(userId);
		return new ResponseEntity<UserDTO>(getUser, HttpStatus.OK);
	}
}
