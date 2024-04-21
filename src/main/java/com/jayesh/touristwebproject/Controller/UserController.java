package com.jayesh.touristwebproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String createUser(@ModelAttribute UserDTO userDTO , BindingResult result, Model m){
		if(result.hasErrors())
			return "index.html";
       // userDTO.setUserId(userService.generateUserId()); 
       UserDTO user=userService.createUser(userDTO);
	   m.addAttribute("user", user);
        return "forward:/";
    }

    @PostMapping("/login")
	public String authenticateCustomer(@ModelAttribute UserLoginDTO userdto, Model m)
	{
		UserDTO getUserByEmailAndPassword = this.userService.getUserByEmailAndPassword(userdto.getEmail(), userdto.getPassword());
		m.addAttribute("user", getUserByEmailAndPassword);
	// return "forward:/";
	return "index.html";
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
