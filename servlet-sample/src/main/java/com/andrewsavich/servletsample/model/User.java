package com.andrewsavich.servletsample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private Integer ID;
	private String login;
	private String password;
	private String firstName;
	private Role role;
}
