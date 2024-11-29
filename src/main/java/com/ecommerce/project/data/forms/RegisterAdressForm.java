package com.ecommerce.project.data.forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterAdressForm {
	
	private String state;
	private String city;
	private String address;
	private String complement;
	private Integer userId;

}
