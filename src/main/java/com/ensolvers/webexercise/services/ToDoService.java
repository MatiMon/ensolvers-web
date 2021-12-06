package com.ensolvers.webexercise.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensolvers.webexercise.domain.Folder;
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

	@Transactional
	public void createToDo(Long folderId, String text) {
		if (!this.folderRepository.existsById(folderId)) {
			throw new RuntimeException("no existe la carpeta.");
		}
		Folder folder = folderRepository.getById(folderId);
		ToDo todo = new ToDo(text);
		folder.add(todo);
	}

	@Transactional
	public void removeToDo(Long folderId, Long toDoId) {
		if (!this.folderRepository.existsById(folderId)) {
			throw new RuntimeException("no existe la carpeta.");
		}
		
		Folder folder = folderRepository.getById(folderId);
		folder.removeById(toDoId);
	}

	@Transactional
	public void changeText(Long folderId, Long toDoId, String text) {
		ToDo toDo = obtainToDo(folderId, toDoId);
		if (toDo != null) {
			toDo.setText(text);
		}

	}

	@Transactional
	public void changeStatus(Long folderId, Long toDoId) {
		if (!this.folderRepository.existsById(folderId)) {
			throw new RuntimeException("no existe la carpeta.");
		}
		Folder folder = folderRepository.getById(folderId);
		ToDo toDo = obtainToDo(folderId, toDoId);
		if (toDo != null) {
			toDo.setStatus(!toDo.getStatus());
		}

	}

	private ToDo obtainToDo(Long folderId, Long toDoId) {
		return folderRepository.getById(folderId).getToDoList().stream().filter(list -> list.getId().equals(toDoId))
				.findAny().orElse(null);
	}

}
