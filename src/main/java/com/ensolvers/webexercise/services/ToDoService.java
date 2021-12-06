package com.ensolvers.webexercise.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ensolvers.webexercise.domain.ToDo;
import com.ensolvers.webexercise.repositories.FolderRepository;

@Service
public class ToDoService {

	private final FolderRepository folderRepository;

	@Autowired
	public ToDoService(FolderRepository folderRepository) {
		this.folderRepository = folderRepository;
	}

	public List<ToDo> getToDoS(Long folderId) {
		if (!this.folderRepository.existsById(folderId)) {
			throw new RuntimeException("no existe la carpeta.");
		}
		return folderRepository.getById(folderId).getToDoList();
	}

	public void createToDo(Long folderId, String text) {
		folderRepository.getById(folderId).add(new ToDo(text));
	}

	public void removeToDo(Long folderId, Long toDoId) {
		ToDo toDo = obtainToDo(folderId, toDoId);
		if (toDo != null) {
			folderRepository.getById(folderId).getToDoList().remove(toDo);
		}
	}
	
	@Transactional
	public void changeText(Long folderId, Long toDoId, String text) {
		ToDo toDo = obtainToDo(folderId, toDoId);
		toDo.setText(text);
	}

	@Transactional
	public void changeStatus(Long folderId, Long toDoId) {
		ToDo toDo = obtainToDo(folderId, toDoId);
		toDo.setStatus(!toDo.getStatus());
	}

	private ToDo obtainToDo(Long folderId, Long toDoId) {
		return folderRepository.getById(folderId).getToDoList().stream()
				.filter(list -> list.getId().equals(toDoId)).findAny().orElse(null);
	}

}
