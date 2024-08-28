package com.ecommerce.project.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String password;
	private String name;
	private String cnpj;
	private String legaName;
	private String cpf;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Address> address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Order> orders;
	
	public User(Long id, String password, String name, String cpf) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.cpf = cpf;
	}

	public User(Long id, String password, String name, String cnpj, String legaName) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.cnpj = cnpj;
		this.legaName = legaName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
