package com.ensolvers.webexercise.domain;

import javax.persistence.Entity;

import com.ensolvers.webexercise.dtos.Persistent;

@Entity(name = "Users")
public class User extends Persistent {
	private String username;
	private String password; // guardar hasheada y aplicar OWASP

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	// omito setters porque no se pide poder modificar usuario y contraseña

}
