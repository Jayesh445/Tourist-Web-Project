package com.jayesh.touristwebproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayesh.touristwebproject.DTO.UserDTO;
import com.jayesh.touristwebproject.DTO.UserLoginDTO;
import com.jayesh.touristwebproject.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/signup")
	public String createUser(@ModelAttribute UserDTO userDTO, BindingResult result, HttpSession session) {
		if (result.hasErrors())
			return "index.html";
		// userDTO.setUserId(userService.generateUserId());
		UserDTO user = userService.createUser(userDTO);
		// m.addAttribute("user", user);
		session.setAttribute("user", user);
		return "forward:/";
	}

	@PostMapping("/login")
	public String authenticateCustomer(@ModelAttribute UserLoginDTO userdto, HttpSession session) {
		UserDTO getUserByEmailAndPassword = this.userService.getUserByEmailAndPassword(userdto.getEmail(),
				userdto.getPassword());
		// m.addAttribute("user", getUserByEmailAndPassword);
		session.setAttribute("user", getUserByEmailAndPassword);
		return "forward:/";
		// return "index.html";
	}

	// @PutMapping("/update/{userId}")
	// public ResponseEntity<UserDTO> updateUser(@ModelAttribute UserDTO userdto,
	// @PathVariable Long userId) {
	// UserDTO updateUser = this.userService.updateUser(userdto, userId);
	// return new ResponseEntity<UserDTO>(updateUser, HttpStatus.OK);
	// }

	// @GetMapping("/get/{userId}")
	// public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
	// UserDTO getUser = this.userService.getUserById(userId);
	// return new ResponseEntity<UserDTO>(getUser, HttpStatus.OK);
	// }
}
