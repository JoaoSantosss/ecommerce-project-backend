package com.ecommerce.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.project.data.dto.NormalUserDTO;
import com.ecommerce.project.data.forms.ResgisterNormalUserForm;
import com.ecommerce.project.models.User;
import com.ecommerce.project.models.enums.Role;
import com.ecommerce.project.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public NormalUserDTO register(ResgisterNormalUserForm form) {
		User user = User.builder()
				.name(form.getName())
				.email(form.getEmail())
				.cpf(form.getCpf())
				.password(passwordEncoder.encode(form.getPassword()))
				.role(Role.USER)
				.build();
		
		userRepository.save(user);
		
		return new NormalUserDTO(user);
	}

}
