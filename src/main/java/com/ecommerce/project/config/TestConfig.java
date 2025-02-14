package com.ecommerce.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecommerce.project.models.User;
import com.ecommerce.project.models.enums.Role;
import com.ecommerce.project.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User userAdmin = User.builder()
				.active(true)
				.email("email@example.com")
				.name("AdminUser")
				.password(passwordEncoder.encode("123456"))
				.phoneNumber("87655443234")
				.cpf("86546786432")
				.role(Role.ADMIN)
				.build();
		
		userRepository.save(userAdmin);
	}
	
	

}
