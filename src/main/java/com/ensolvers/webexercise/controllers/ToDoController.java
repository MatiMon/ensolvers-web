package com.ensolvers.webexercise.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.webexercise.domain.ToDo;
import com.ensolvers.webexercise.services.ToDoService;

@RestController
@RequestMapping("/user/{userId}/folder/{folderId}/toDo")
public class ToDoController {
	private final ToDoService toDoService;
	
	@Autowired
	public ToDoController(ToDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	@GetMapping
	public List<ToDo> getToDoS(@PathVariable Long folderId){
		return this.toDoService.getToDoS(folderId);
	}
	
	@PostMapping
	public void createToDo(@PathVariable Long folderId, @RequestParam("text") String text) {
		this.toDoService.createToDo(folderId, text);
	}
	
	@DeleteMapping(value = "/{toDoId}")
	public void deleteToDo(@PathVariable Long folderId, @PathVariable Long toDoId) {
		this.toDoService.removeToDo(folderId, toDoId);
	}
	
	@PatchMapping(value = "/{toDoId}")
	public void changeStatus(@PathVariable Long folderId, @PathVariable Long toDoId) {
		this.toDoService.changeStatus(folderId, toDoId);
	}
	
	@PutMapping(value = "/{toDoId}")
	public void changeText(@PathVariable Long folderId, @PathVariable Long toDoId, @RequestParam("text") String text) {
		this.toDoService.changeText(folderId, toDoId, text);
	}
}
