package com.cdac.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entities.User;

public interface UserDao extends JpaRepository<User, Long> {
//add dup check for email
	boolean existsByEmail(String email);
	//add derived query method
	Optional<User> findByEmailAndPassword(String em,String pass);
}
