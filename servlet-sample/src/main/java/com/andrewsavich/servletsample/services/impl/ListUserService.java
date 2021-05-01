package com.andrewsavich.servletsample.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.andrewsavich.servletsample.model.Role;
import com.andrewsavich.servletsample.model.User;
import com.andrewsavich.servletsample.services.UserService;

public class ListUserService implements UserService {

	private static UserService service;

	private List<User> users = new ArrayList<>();

	private ListUserService() {

		users.add(new User(1, "admin", "admin", "Andrew", Role.ADMIN));
		users.add(new User(2, "user2", "user2", "User2", Role.USER));
		users.add(new User(3, "user3", "user3", "User3", Role.USER));
		users.add(new User(4, "user4", "user4", "User4", Role.USER));
		users.add(new User(5, "user5", "user5", "User5", Role.USER));

	}

	public static UserService getService() {
		if (service == null) {
			service = new ListUserService();
		}

		return service;
	}

	@Override
	public List<User> getAllUsers() {
		return new ArrayList<>(users);
	}

	@Override
	public User getUserByLogin(String login) {
		return users.stream().filter(u -> u.getLogin().equals(login)).findAny().orElse(null);
	}

	@Override
	public void deleteUser(Integer id) {
		User toBeDelete = users.stream().filter(u -> u.getID().equals(id)).findAny().orElse(null);
		users.remove(toBeDelete);
	}

}
