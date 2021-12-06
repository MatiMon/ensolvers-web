package com.ensolvers.webexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensolvers.webexercise.domain.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long>{

}
