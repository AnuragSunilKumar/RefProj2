package com.devon.refferal.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	private String  rolename;
	private String roleDescription;
	public String getRolename() {
		return rolename;
	}
	
	
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	
	
	
	
	
	
	
	

}
