package com.ensolvers.webexercise.repositories;

import java.util.ArrayList;
import java.util.List;

import com.ensolvers.webexercise.domain.Folder;

public class FolderRepository {
	private List<Folder> folderList = new ArrayList<Folder>();
	private static FolderRepository instancia = new FolderRepository(); // Singleton

	public List<Folder> getFolderList() {
		return folderList;
	}

	public void add(Folder folder) {
		this.folderList.add(folder);
	}

	public void remove(Folder folder) {
		if (!this.folderList.remove(folder)) {
			throw new RuntimeException("no existe la carpeta.");
		}
	}

	public static FolderRepository getInstancia() {
		return instancia;
	}

}
