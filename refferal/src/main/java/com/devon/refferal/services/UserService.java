package com.devon.refferal.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devon.refferal.dao.RoleRepository;
import com.devon.refferal.dao.UserRepository;
import com.devon.refferal.entites.Role;
import com.devon.refferal.entites.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public User registerNewUser(User user)
	{
		
		Role role = roleRepository.findById("User").get();
		
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		user.setPassword(getEncodedPassword(user.getPassword()));
		 return userRepository.save(user);
	}
	
	public void initRolesAndUsers() {
		Role adminRole = new Role();
		adminRole.setRolename("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleRepository.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRolename("User");
		userRole.setRoleDescription("Default role for new user");
		roleRepository.save(userRole);
		
		User adminUser = new User();
		adminUser.setName("UAdmin");
		adminUser.setEmail("admin@gmail.com");
		adminUser.setPassword(getEncodedPassword("admin123"));
		Set<Role>adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userRepository.save(adminUser);
		
		/*
		 * User user = new User(); user.setName("Anurag");
		 * user.setEmail("anurag@gmail.com");
		 * user.setPassword(getEncodedPassword("anurag123")); Set<Role>userRoles = new
		 * HashSet<>(); userRoles.add(userRole); user.setRole(userRoles);
		 * userRepository.save(user);
		 */
		
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
