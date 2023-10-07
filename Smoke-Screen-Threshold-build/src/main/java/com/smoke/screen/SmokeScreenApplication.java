package com.smoke.screen;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.smoke.screen.entities.Permissions;
import com.smoke.screen.entities.Role;
import com.smoke.screen.repos.PermissionsRepo;
import com.smoke.screen.repos.RoleRepo;
import com.smoke.screen.utilities.AppConstants;

@SpringBootApplication
public class SmokeScreenApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private PermissionsRepo permissionsRepo;

	public static void main(String[] args) {
		SpringApplication.run(SmokeScreenApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.passwordEncoder.encode("xyz"));

		try {

			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");

			List<Role> roles = List.of(role, role1);

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(r -> {
				System.out.println(r.getName());
			});
			
			Permissions permission = new Permissions();
			permission.setId(1);
			permission.setName("LOGIN");
			permission.setStatus(0);

			Permissions permission1 = new Permissions();
			permission1.setId(2);
			permission1.setName("SIGNUP");
			permission1.setStatus(0);
			
			List<Permissions> permissions = List.of(permission, permission1);

			List<Permissions> res = this.permissionsRepo.saveAll(permissions);

			res.forEach(r -> {
				System.out.println(r.getName());
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
