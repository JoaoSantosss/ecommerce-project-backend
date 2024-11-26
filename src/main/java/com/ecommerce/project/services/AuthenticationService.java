package com.ecommerce.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.ecommerce.project.data.AuthenticationResponse;
import com.ecommerce.project.data.forms.AuthenticateForm;
import com.ecommerce.project.models.User;
import com.ecommerce.project.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	

	public AuthenticationResponse authenticate(AuthenticateForm form) {
		
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							form.getEmail(), 
							form.getPassword()
							)
					);
			User user = userRepository.findByEmail(form.getEmail()).orElseThrow();
			String jwtToken = jwtService.generateToken(user);
			return AuthenticationResponse.builder().token(jwtToken).build();
		
		
	}

}
