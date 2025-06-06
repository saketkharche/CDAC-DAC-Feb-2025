package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entities.User;

public interface UserDao extends JpaRepository<User, Long> {
//add dup check for email
	boolean existsByEmail(String email);
}
