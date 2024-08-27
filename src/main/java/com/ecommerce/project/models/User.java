package com.ecommerce.project.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	private Integer id;
	private String password;
	private String name;
	private String cnpj;
	private String legaName;
	private String cpf;
	
	public User(Integer id, String password, String name, String cpf) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.cpf = cpf;
	}

	public User(Integer id, String password, String name, String cnpj, String legaName) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.cnpj = cnpj;
		this.legaName = legaName;
	}
	
	
}
