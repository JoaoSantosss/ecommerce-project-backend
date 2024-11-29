package com.ecommerce.project.data.dto;

import com.ecommerce.project.models.SellerUser;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
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
		this.email = sellerUser.getUser().getEmail();
		this.name = sellerUser.getUser().getName();
		this.cpf = sellerUser.getUser().getCpf();
		this.cnpj = sellerUser.getCnpj();
		this.legalName = sellerUser.getLegalName();
	} 
	
}
