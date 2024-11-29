package com.ecommerce.project.data.dto;

import com.ecommerce.project.models.Address;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAddressDTO {
	
	private Integer id;
	private String state;
	private String city;
	private String address;
	private String complement;
	private NormalUserDTO userDTO;

	public UserAddressDTO(Address address) {
		this.id = address.getId();
		this.state = address.getState();
		this.city = address.getCity();
		this.address = address.getAddress();
		this.complement = address.getComplement();
		this.userDTO =  new NormalUserDTO(address.getUser());
	}

}
