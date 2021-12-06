package com.ensolvers.webexercise.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ensolvers.webexercise.domain.Folder;
import com.ensolvers.webexercise.domain.User;
import com.ensolvers.webexercise.services.FolderService;

@RequestMapping("/folder")
public class FolderController {
	private final FolderService folderService;
	
	@Autowired
	public FolderController(FolderService folderService) {
		this.folderService = folderService;
	}
	
	@GetMapping
	public List<Folder> getFolders(){
		return this.folderService.getFolders();
	}
	
	@PostMapping
	public void createFolder(@RequestBody User user, @RequestBody String name) {
		this.folderService.createFolder(user, name);
	}
	
	@DeleteMapping(value = "/{folderId}")
	public void deleteFolder(@PathVariable Long folderId) {
		this.folderService.removeFolder(folderId);
	}
	

	
}
