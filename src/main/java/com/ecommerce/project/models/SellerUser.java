package com.ecommerce.project.models;

import com.ecommerce.project.models.enums.Role;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class SellerUser extends User{

	private static final long serialVersionUID = 1L;

	private String cnpj;
	private String legalName;
	
	public SellerUser(String password, String name, String cpf, 
			String cnpj,String legalName) {
		super(null, password, name, cpf, Role.SELLER);
		this.cnpj = cnpj;
		this.legalName = legalName;
	}
	
	public SellerUser() {
		super();
		this.setRole(Role.SELLER);

	}
	
	
	
	
	
}
