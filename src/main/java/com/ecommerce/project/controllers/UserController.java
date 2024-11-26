package com.ecommerce.project.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.project.data.dto.NormalUserDTO;
import com.ecommerce.project.data.forms.ResgisterNormalUserForm;
import com.ecommerce.project.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<NormalUserDTO> register(@RequestBody ResgisterNormalUserForm form){
		
		NormalUserDTO user = userService.register(form); 

		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(uri).body(user);
	}

}
