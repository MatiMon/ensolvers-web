package com.ensolvers.webexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensolvers.webexercise.domain.User;

public interface IUserRepository extends JpaRepository<User, Long>{

}
