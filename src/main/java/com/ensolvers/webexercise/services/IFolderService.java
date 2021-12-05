package com.ensolvers.webexercise.services;

import com.ensolvers.webexercise.domain.Folder;
import com.ensolvers.webexercise.domain.ToDo;

public interface IFolderService {
	
	//Referido a los ToDo
	public void postToDo(ToDo toDo); // TODO revisar retorno
	public void deleteToDo(ToDo toDo); // TODO revisar retorno
	public void putToDo(ToDo toDo); // TODO revisar retorno
	
	//Referido a las Folders
	public void postFolder(Folder folder); // TODO revisar retorno
	public void deleteFolder(Folder folder); // TODO revisar retorno
	public void putFolder(Folder folder); // TODO revisar retorno
	
}
