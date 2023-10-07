package com.smoke.screen.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoke.screen.entities.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
