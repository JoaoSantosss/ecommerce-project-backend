package com.ecommerce.project.models;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce.project.models.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Builder
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	private String email;
	private String password;
	private String name;
	private String cnpj;
	private String legaName;
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Address> address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Order> orders;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
	private List<Product> products;
	
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
	public String getPassword() {
		return password;
	}




	
}
