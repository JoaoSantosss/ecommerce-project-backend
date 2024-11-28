package com.ecommerce.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.project.data.dto.NormalUserDTO;
import com.ecommerce.project.data.dto.SellerUserDTO;
import com.ecommerce.project.data.forms.RegisterSellerUserForm;
import com.ecommerce.project.data.forms.ResgisterNormalUserForm;
import com.ecommerce.project.models.SellerUser;
import com.ecommerce.project.models.User;
import com.ecommerce.project.models.enums.Role;
import com.ecommerce.project.repositories.SellerUserRepository;
import com.ecommerce.project.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SellerUserRepository sellerUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public NormalUserDTO registerUser(ResgisterNormalUserForm form) {
		User user = User.builder()
				.active(true)
				.name(form.getName())
				.email(form.getEmail())
				.cpf(form.getCpf())
				.password(passwordEncoder.encode(form.getPassword()))
				.role(Role.USER)
				.build();
		
		userRepository.save(user);
		
		return new NormalUserDTO(user);
	}

	public SellerUserDTO registerSeller(RegisterSellerUserForm form) {
		
		User user = User.builder()
				.active(true)
				.email(form.getEmail())
				.name(form.getName())
				.password(passwordEncoder.encode(form.getPassword()))
				.cpf(form.getCpf())
				.role(Role.SELLER)
				.build();
		
		SellerUser sellerUser = SellerUser.builder()
				.user(user)
				.cnpj(form.getCnpj())
				.legalName(form.getLegalName())
				.build();
		
		userRepository.save(user);
		sellerUserRepository.save(sellerUser);
		
		
		return new SellerUserDTO(sellerUser);
	}

}
