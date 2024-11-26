package com.ecommerce.project.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.data.AuthenticationResponse;
import com.ecommerce.project.data.forms.AuthenticateForm;
import com.ecommerce.project.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;

	
	@PostMapping
	public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticateForm form){
		return ResponseEntity.ok(authenticationService.authenticate(form));
	}
	
}
