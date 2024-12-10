package com.ecommerce.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
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
	
	@Value("${application.frontendurl}")
	private String frontendURL;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SellerUserRepository sellerUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	

	
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
			
			String token = jwtService.generateToken(user.get());
			String subject = "Recuperar Senha";
			String paragraph = String.format("Clique aqui para recuperar a sua senha: %s/?token=%s",frontendURL, token );
			
			
			publisher.publishEvent(new GenericEmailEvent(this, email, subject, paragraph));
			
		}
		
	}

}
