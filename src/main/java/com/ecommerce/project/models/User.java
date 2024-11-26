package com.ecommerce.project.models;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce.project.models.enums.Role;

import jakarta.persistence.Column;
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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String cpf;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Address> address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Order> orders;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
	private List<Product> products;
	
	
    @CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date createdAt;
    
    @UpdateTimestamp
    private Date updatedAt;
	
	public User(Integer id, String password, String name, String cpf, Role role) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.cpf = cpf;
		this.role = role;
		this.createdAt = new Date();
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
