package com.ensolvers.webexercise.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ensolvers.webexercise.domain.Folder;
import com.ensolvers.webexercise.domain.User;
import com.ensolvers.webexercise.repositories.FolderRepository;
import com.ensolvers.webexercise.repositories.UserRepository;

@Service
public class FolderService {
	private final FolderRepository folderRepository;
	private final UserRepository userRepository;

	@Autowired
	public FolderService(FolderRepository folderRepository, UserRepository userRepository) {
		this.folderRepository = folderRepository;
		this.userRepository = userRepository;
	}

	public List<Folder> getFolders(Long userId) {
		return folderRepository.findAll().stream().filter(list -> list.getUser().getId().equals(userId)).collect(Collectors.toList());
	}

	public void createFolder(Long userId, String name) {
		if(!this.userRepository.existsById(userId)) {
			throw new RuntimeException("no exist el usuario");
		}
		User user = userRepository.getById(userId);
		Folder folder = new Folder(name, user);
		this.folderRepository.save(folder);
	}

	public void removeFolder(Long folderId) {
		if (!this.folderRepository.existsById(folderId)) {
			throw new RuntimeException("no existe la carpeta.");
		} else
			this.folderRepository.deleteById(folderId);
	}

	private User obtainUser(Long userId) {
		return userRepository.getById(userId);
	}

}
