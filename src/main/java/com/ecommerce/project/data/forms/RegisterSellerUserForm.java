package com.ecommerce.project.data.forms;

import com.ecommerce.project.models.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterSellerUserForm {
	
	private String email;
	private String password;
	private String name;
	private String cnpj;
	private String legalName;
	private String cpf;
	private Role role;

}
