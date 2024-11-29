package com.ecommerce.project.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.project.data.dto.UserAddressDTO;
import com.ecommerce.project.data.forms.RegisterAdressForm;
import com.ecommerce.project.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping
	public ResponseEntity<UserAddressDTO> addAddress(RegisterAdressForm form) {
		
		UserAddressDTO userAddressDTO = addressService.addAddressToUser(form);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userAddressDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(userAddressDTO);
	}

}
