package com.ensolvers.webexercise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensolvers.webexercise.domain.User;
import com.ensolvers.webexercise.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getUsers(){
		return this.userRepository.findAll();
	}
	
	public void createUser(String username, String password) {
		this.userRepository.save(new User(username, password));
	}

}
