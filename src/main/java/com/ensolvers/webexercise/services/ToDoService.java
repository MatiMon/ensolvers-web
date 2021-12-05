package com.ensolvers.webexercise.services;

import org.springframework.stereotype.Service;

import com.ensolvers.webexercise.domain.Folder;
import com.ensolvers.webexercise.domain.ToDo;

@Service
public class ToDoService implements IToDoService {

	@Override
	public void createToDo(String text, Folder folder) {
		ToDo todo = new ToDo(text);
		folder.add(todo);	
	}

	@Override
	public void removeToDo(ToDo toDo, Folder folder) {
		if(!folder.getToDoList().remove(toDo)) {
			throw new RuntimeException("el To Do no pertenecia a la carpeta.");
		}
	}

	@Override
	public void editToDo(String text, ToDo toDo, Folder folder) {
		ToDo anotherToDo = obtainToDo(toDo, folder);
		if(anotherToDo != null) {
			anotherToDo.setText(text);
		}		
	}

	@Override
	public void changeStatus(ToDo toDo, Folder folder) {
		ToDo anotherToDo = obtainToDo(toDo, folder);
		if(anotherToDo != null) {
			anotherToDo.setStatus(!anotherToDo.getStatus());
		}	
		
	}
	
	private ToDo obtainToDo(ToDo toDo, Folder folder) {
		return folder.getToDoList().stream().filter(list -> list.equals(toDo)).findAny().orElse(null);
	}

}
