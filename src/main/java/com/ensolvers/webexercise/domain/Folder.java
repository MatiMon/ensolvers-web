package com.ensolvers.webexercise.domain;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	private String name;
	private List<ToDo> toDoList;
	private User user;

	public Folder(String name, User user) {
		this.name = name;
		this.user = user;
		this.toDoList = new ArrayList<ToDo>();
	}

	public String getName() {
		return name;
	}
	
	public User getUser() {
		return user;
	}

	public List<ToDo> getToDoList() {
		return toDoList;
	}
	// omito setter de name y user porque no se pide poder cambiar de nombre ni de usuario
	
	public void add(ToDo toDo) {
		this.toDoList.add(toDo);
	}
	
	public void remove(ToDo toDo) {
		if(!this.toDoList.remove(toDo)) {
			throw new RuntimeException("el To Do no pertenecía a esta carpeta.");
		}
	}
}
