package com.devon.refferal.config;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.devon.refferal.dao.UserRepository;
import com.devon.refferal.entites.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 User user = userRepository.getUserByUserName(username);
		 if(user == null)
		 {
			 throw new UsernameNotFoundException("User not found");
		 }
		
		 CustomUserDetails customUserDetails = new CustomUserDetails(user);
		
		 return customUserDetails;
	}

}
*/