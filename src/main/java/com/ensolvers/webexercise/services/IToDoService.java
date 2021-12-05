package com.ensolvers.webexercise.services;

import com.ensolvers.webexercise.domain.Folder;
import com.ensolvers.webexercise.domain.ToDo;

public interface IToDoService {
	
	public void createToDo(String text, Folder folder);
	public void removeToDo(ToDo toDo, Folder folder);
	public void editToDo(String text, ToDo toDo, Folder folder);
	public void changeStatus(ToDo toDo, Folder folder);

}
