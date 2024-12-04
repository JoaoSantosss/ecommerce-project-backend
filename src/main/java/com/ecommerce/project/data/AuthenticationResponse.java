package com.ecommerce.project.data;

import com.ecommerce.project.data.dto.NormalUserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	
	private String token;
	private NormalUserDTO userDto;

}
