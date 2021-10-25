package com.devon.refferal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devon.refferal.entites.Role;
import com.devon.refferal.services.RoleService;

@RestController
public class RoleContoller {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping({"/createNewRole"})
	public Role createNewRole(@RequestBody Role role) {
		 return roleService.createNewRole(role);
	}
}
