package com.ensolvers.webexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensolvers.webexercise.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
