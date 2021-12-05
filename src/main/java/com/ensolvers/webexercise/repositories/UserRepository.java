package com.ensolvers.webexercise.repositories;

import java.util.ArrayList;
import java.util.List;

import com.ensolvers.webexercise.domain.User;

public class UserRepository {
	private List<User> userList = new ArrayList<User>();
	private static UserRepository instancia = new UserRepository(); // Singleton

	public List<User> getUserList() {
		return userList;
	}

	public void add(User user) {
		this.userList.add(user);
	}

	public void remove(User user) {
		if (!this.userList.remove(user)) {
			throw new RuntimeException("no existe el usuario.");
		}
	}

	public static UserRepository getInstancia() {
		return instancia;
	}

}
