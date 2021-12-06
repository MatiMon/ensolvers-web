package com.ensolvers.webexercise.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ensolvers.webexercise.dtos.Persistent;

@Entity(name = "Folders")
public class Folder extends Persistent {

	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ToDo> toDoList;

	@ManyToOne
	private User user;

	public Folder(String name, User user) {
		this.name = name;
		this.user = user;
		this.toDoList = new ArrayList<ToDo>();
	}

	public Folder() {
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
	// omito setter de name y user porque no se pide poder cambiar de nombre ni de
	// usuario

	public void add(ToDo toDo) {
		this.toDoList.add(toDo);
	}

	public void removeById(Long toDoId) {
		ToDo toDo = this.toDoList.stream().filter(list -> list.getId().equals(toDoId)).findAny().orElse(null);
		if (toDo == null) {
			throw new RuntimeException("el To Do no pertenecía a esta carpeta.");
		}
		this.toDoList.remove(toDo);
	}
}
