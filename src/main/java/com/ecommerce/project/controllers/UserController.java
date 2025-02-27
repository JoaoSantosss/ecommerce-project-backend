package com.ecommerce.project.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.project.data.dto.NormalUserDTO;
import com.ecommerce.project.data.dto.SellerUserDTO;
import com.ecommerce.project.data.forms.RegisterSellerUserForm;
import com.ecommerce.project.data.forms.ResgisterNormalUserForm;
import com.ecommerce.project.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<NormalUserDTO> register(@RequestBody ResgisterNormalUserForm form){
		
		NormalUserDTO user = userService.registerUser(form); 

		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@PostMapping("/seller")
	public ResponseEntity<SellerUserDTO> registerSeller(@RequestBody RegisterSellerUserForm form){
		
		SellerUserDTO user = userService.registerSeller(form); 

		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@PutMapping("/change-password")
	public ResponseEntity<?> changePassword(String token, String newPassword) {
		
		userService.changePassword(token, newPassword);
		return ResponseEntity.ok("Password changed");
	}
	
	@PostMapping("/forgot-password")
	public ResponseEntity<?> forgotPassword(String email) { 
		userService.forgotPassword(email);
		return ResponseEntity.ok("Verifique seu email");
	}

}
