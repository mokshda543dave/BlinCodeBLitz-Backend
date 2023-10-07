package com.smoke.screen.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoke.screen.entities.Solution;
import com.smoke.screen.entities.User;

public interface SolutionRepo extends JpaRepository<Solution, Integer>{

	Solution findByUser(User user);
}
