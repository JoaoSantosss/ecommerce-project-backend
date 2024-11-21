package com.ecommerce.project.data.dto;

import com.ecommerce.project.models.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NormalUserDTO {
	
	private Integer id;
	private String email;
	private String name;
	private String cpf;
	
	public NormalUserDTO(User user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
		this.cpf = user.getCpf();
	} 
	
	

}
