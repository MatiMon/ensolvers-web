package com.ensolvers.webexercise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ensolvers.webexercise.domain.Folder;
import com.ensolvers.webexercise.domain.User;
import com.ensolvers.webexercise.repositories.FolderRepository;

@Service
public class FolderService {
	private final FolderRepository folderRepository;

	@Autowired
	public FolderService(FolderRepository folderRepository) {
		this.folderRepository = folderRepository;
	}
	
	public List<Folder> getFolders() {
		return folderRepository.findAll();
	}

	
	public void createFolder(User user, String name) {
		Folder folder = new Folder(name, user);
		this.folderRepository.save(folder);
	}

	
	public void removeFolder(Long folderId) {
		if(!this.folderRepository.existsById(folderId)) {
			throw new RuntimeException("no existe la carpeta.");
		} else this.folderRepository.deleteById(folderId);	
	}
	

}
