package com.ecommerce.project.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	private String state;
	private String city;
	private String address;
	private String complement;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
}
