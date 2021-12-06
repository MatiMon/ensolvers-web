package com.ensolvers.webexercise.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.webexercise.domain.Folder;
import com.ensolvers.webexercise.domain.User;
import com.ensolvers.webexercise.services.FolderService;

@RestController
@RequestMapping("/user/{userId}/folder")
public class FolderController {
	private final FolderService folderService;

	@Autowired
	public FolderController(FolderService folderService) {
		this.folderService = folderService;
	}

	@GetMapping
	public List<Folder> getFolders(@PathVariable Long userId) {
		return this.folderService.getFolders(userId);
	}

	@PostMapping
	public void createFolder(@PathVariable Long userId, @RequestParam("name") String name) {
		this.folderService.createFolder(userId, name);
	}

	@DeleteMapping(value = "/{folderId}")
	public void deleteFolder(@PathVariable Long folderId) {
		this.folderService.removeFolder(folderId);
	}

}
