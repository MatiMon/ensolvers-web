package com.ensolvers.webexercise.domain;

public class User {

	private String username;
	private String password; // hashear

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	//omito setters porque no se pide poder modificar usuario y contraseña

}
