package com.ecommerce.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.project.controllers.auth.AuthenticationResponse;
import com.ecommerce.project.models.User;
import com.ecommerce.project.models.enums.Role;
import com.ecommerce.project.models.forms.AuthenticateForm;
import com.ecommerce.project.models.forms.ResgisterForm;
import com.ecommerce.project.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	private JwtService jwtService;
	
	public AuthenticationResponse register(ResgisterForm form) {
		User user = User.builder()
				.name(form.getName())
				.email(form.getEmail())
				.cpf(form.getCpf())
				.password(passwordEncoder.encode(form.getPassword()))
				.role(Role.USER)
				.build();
		
		userRepository.save(user);
		
		String jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticateForm form) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword()
						));
		User user = userRepository.findByEmail(form.getEmail()).get();
		String jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(jwtToken).build();
		
	}

}
