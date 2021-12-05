package com.ensolvers.webexercise.repositories;

import java.util.List;

import com.ensolvers.webexercise.domain.User;

public class UserRepository {
	private List<User> userList;

	public UserRepository() {// implementar singleton
	}

	public List<User> getUserList() {
		return userList;
	}
	public void add(User user) {
		this.userList.add(user);
	}
	
	public void remove(User user) {
		if(!this.userList.remove(user)) {
			throw new RuntimeException("no existe el usuario.");
		}
	}

}
