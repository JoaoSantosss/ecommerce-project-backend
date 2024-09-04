package com.ecommerce.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);

}
