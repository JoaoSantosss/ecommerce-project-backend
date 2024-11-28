package com.ecommerce.project.data.forms;

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

}
