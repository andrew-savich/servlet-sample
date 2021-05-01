package com.andrewsavich.servletsample.services;

import java.util.List;

import com.andrewsavich.servletsample.model.User;

public interface UserService {
	List<User> getAllUsers();
	
	User getUserByLogin(String login);
	
	void deleteUser(Integer id);
}
