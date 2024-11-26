package com.ecommerce.project.data.dto;

import com.ecommerce.project.models.SellerUser;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SellerUserDTO {

	private Integer id;
	private String email;
	private String name;
	private String cpf;
	private String cnpj;
	private String legalName;
	
	public SellerUserDTO(SellerUser sellerUser) {
		super();
		this.id = sellerUser.getId();
		this.email = sellerUser.getEmail();
		this.name = sellerUser.getName();
		this.cpf = sellerUser.getCpf();
		this.cnpj = sellerUser.getCnpj();
		this.legalName = sellerUser.getLegalName();
	} 
	
}
