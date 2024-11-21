package com.ecommerce.project.controllers.auth;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.project.data.dto.NormalUserDTO;
import com.ecommerce.project.models.User;
import com.ecommerce.project.models.forms.AuthenticateForm;
import com.ecommerce.project.models.forms.ResgisterForm;
import com.ecommerce.project.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody ResgisterForm form){
		
		User user = new User();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(user.getId())
				.toUri();
		
		return ResponseEntity.created().body());
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticateForm form){
		return ResponseEntity.ok(authenticationService.authenticate(form));
	}
	
}
