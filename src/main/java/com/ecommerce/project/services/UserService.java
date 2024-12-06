package com.ecommerce.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.project.data.dto.NormalUserDTO;
import com.ecommerce.project.data.dto.SellerUserDTO;
import com.ecommerce.project.data.forms.RegisterSellerUserForm;
import com.ecommerce.project.data.forms.ResgisterNormalUserForm;
import com.ecommerce.project.events.GenericEmailEvent;
import com.ecommerce.project.models.SellerUser;
import com.ecommerce.project.models.User;
import com.ecommerce.project.models.enums.Role;
import com.ecommerce.project.repositories.SellerUserRepository;
import com.ecommerce.project.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SellerUserRepository sellerUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ApplicationContext applicationContext;

	
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

	public void changePassword(String token, String newPassword) {
		
		String userName = jwtService.extractUsername(token);
		User user = userRepository.findByEmail(userName).get();
		user.setPassword(passwordEncoder.encode(newPassword));
		
		userRepository.save(user);
	}

	public void forgotPassword(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		
		if (user.isPresent()) {
			applicationContext.publishEvent(new GenericEmailEvent(user, email, email, email, null));
		}
		
	}

}
