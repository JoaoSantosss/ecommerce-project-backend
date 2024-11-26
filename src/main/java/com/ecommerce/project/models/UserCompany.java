package com.ecommerce.project.models;

import com.ecommerce.project.models.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCompany extends User{

	private static final long serialVersionUID = 1L;

	private String cnpj;
	private String legalName;
	
	public UserCompany(String password, String name, String cpf, Role role, 
			String cnpj,String legalName) {
		super(null, password, name, cpf, role);
		this.cnpj = cnpj;
		this.legalName = legalName;
	}
	
	
	
	
}
