package com.devon.refferal.entites;

import com.devon.refferal.dto.UserDTO;

public class JwtResponse {
	
	private UserDTO userDTO;
	private String jwtToken;
	public JwtResponse(UserDTO userDTO, String jwtToken) {
		super();
		this.userDTO = userDTO;
		this.jwtToken = jwtToken;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	
	
	

}
