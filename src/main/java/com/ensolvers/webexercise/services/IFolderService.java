package com.ensolvers.webexercise.services;

import com.ensolvers.webexercise.domain.Folder;
import com.ensolvers.webexercise.domain.ToDo;
import com.ensolvers.webexercise.domain.User;

public interface IFolderService {
	
	public void createFolder(String name, User user);
	public void removeFolder(Folder folder, User user); // obtener por id	
}
