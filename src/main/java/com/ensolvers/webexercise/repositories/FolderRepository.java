package com.ensolvers.webexercise.repositories;

import java.util.ArrayList;
import java.util.List;

import com.ensolvers.webexercise.domain.Folder;

public class FolderRepository {
	private List<Folder> folderList;

	public FolderRepository() { // implementar singleton
		this.folderList = new ArrayList<Folder>();
	}

	public List<Folder> getFolderList() {
		return folderList;
	}
	
	public void add(Folder folder) {
		this.folderList.add(folder);
	}
	
	public void remove(Folder folder) {
		if(!this.folderList.remove(folder)) {
			throw new RuntimeException("no existe la carpeta.");
		}
	}

}
