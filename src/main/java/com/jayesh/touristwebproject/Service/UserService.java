package com.jayesh.touristwebproject.Service;

import com.jayesh.touristwebproject.DTO.UserDTO;

public interface UserService {

    public UserDTO createUser(UserDTO user);

    public UserDTO updateUser(UserDTO user, Long userId);

	public UserDTO getUserByEmailAndPassword(String email, String password);
	
	public UserDTO getUserById(Long userId);

}
