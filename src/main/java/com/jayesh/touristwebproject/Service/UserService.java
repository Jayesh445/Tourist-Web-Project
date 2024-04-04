package com.jayesh.touristwebproject.Service;

import java.util.List;

import com.jayesh.touristwebproject.DTO.UserDTO;

public interface UserService {

    public UserDTO createUser(UserDTO user);

    public UserDTO updateUser(UserDTO user, Long userId);

	public UserDTO getUserByEmailAndPassword(String email, String password);
	
	public UserDTO getUserById(Long userId);

	public List<UserDTO> getAllUsers();

	public void deleteUserById(Long ID);
}
