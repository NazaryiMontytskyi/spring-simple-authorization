package com.nmontytskyi.simpleauth;

import com.nmontytskyi.simpleauth.models.Role;
import com.nmontytskyi.simpleauth.models.User;
import com.nmontytskyi.simpleauth.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class SimpleauthApplication {

	UserService userService;

	public SimpleauthApplication(UserService userService) {
		this.userService = userService;

		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setRoles(List.of(Role.ROLE_USER, Role.ROLE_ADMIN));

		User regularUser = new User();
		regularUser.setUsername("user");
		regularUser.setPassword("12345");
		regularUser.setRoles(List.of(Role.ROLE_USER));

		this.userService.saveUser(admin);
		this.userService.saveUser(regularUser);
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleauthApplication.class, args);
	}

}
