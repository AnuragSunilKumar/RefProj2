package com.devon.refferal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devon.refferal.dao.RoleRepository;
import com.devon.refferal.entites.Role;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role createNewRole(Role role) {
		return roleRepository.save(role);
	}
}
