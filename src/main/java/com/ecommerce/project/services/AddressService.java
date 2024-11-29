package com.ecommerce.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.data.dto.UserAddressDTO;
import com.ecommerce.project.data.forms.RegisterAdressForm;
import com.ecommerce.project.models.Address;
import com.ecommerce.project.models.User;
import com.ecommerce.project.repositories.AddressRepository;
import com.ecommerce.project.repositories.UserRepository;

@Service
public class AddressService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;

	public UserAddressDTO addAddressToUser(RegisterAdressForm form) {
		
		User user = userRepository.getReferenceById(form.getUserId());
		Address address = createNewAdress(form, user);
		
		addressRepository.save(address);
		user.addAddress(address);
		userRepository.save(user);
		return new UserAddressDTO(address);
		
	}

	private Address createNewAdress(RegisterAdressForm form, User user) {
		return Address.builder()
				.address(form.getAddress())
				.city(form.getCity())
				.complement(form.getComplement())
				.state(form.getState())
				.user(user)
				.build();
	}
	
	

}
