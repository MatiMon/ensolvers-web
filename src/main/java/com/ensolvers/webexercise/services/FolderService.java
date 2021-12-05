package com.ensolvers.webexercise.services;

import org.springframework.stereotype.Service;

import com.ensolvers.webexercise.domain.Folder;
import com.ensolvers.webexercise.domain.ToDo;
import com.ensolvers.webexercise.domain.User;
import com.ensolvers.webexercise.repositories.FolderRepository;

@Service
public class FolderService implements IFolderService{

	@Override
	public void createFolder(String name, User user) {
		Folder folder = new Folder(name, user);
		FolderRepository.getInstancia().add(folder);
	}

	@Override
	public void removeFolder(Folder folder, User user) {
		FolderRepository.getInstancia().getFolderList().stream().filter(list -> list.equals(user)); // && filter.equals(id)
		//TODO
	}	
	
}
