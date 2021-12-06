package com.ensolvers.webexercise.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ensolvers.webexercise.dtos.Persistent;


@Entity(name = "Folders")
public class Folder extends Persistent{
	
	private String name;
	
	@OneToMany
	private List<ToDo> toDoList;
	
	@ManyToOne
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
