package com.smoke.screen.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoke.screen.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
	
}
