package com.devon.refferal.dto;

import java.util.Set;

import com.devon.refferal.entites.Role;

public class UserDTO {

	
	private  String name;
	private String email;
	private String rolename;


	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
}
