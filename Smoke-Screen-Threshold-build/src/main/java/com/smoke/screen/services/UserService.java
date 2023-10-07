package com.smoke.screen.services;

import java.util.List;

import com.smoke.screen.payloads.UserDTO;

public interface UserService {

	//	For User
	
	UserDTO createUser(UserDTO user);
	
	//	For Admin
	
	UserDTO getUserById(Integer userId);
	List<UserDTO> getAllUsers();
	
	// Not needed but implemented
	
	void deleteUser(Integer userId);
	UserDTO updateUser(UserDTO user, Integer userId);
}
