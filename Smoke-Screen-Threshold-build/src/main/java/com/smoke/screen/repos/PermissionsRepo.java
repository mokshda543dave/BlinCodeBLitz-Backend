package com.smoke.screen.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoke.screen.entities.Permissions;

public interface PermissionsRepo extends JpaRepository<Permissions, Integer> {

	Optional<Permissions> findByName(String name);
}
