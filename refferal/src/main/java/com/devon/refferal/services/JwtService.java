package com.devon.refferal.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devon.refferal.dao.UserRepository;
import com.devon.refferal.dto.UserDTO;
import com.devon.refferal.entites.JwtRequest;
import com.devon.refferal.entites.JwtResponse;
import com.devon.refferal.entites.Role;
import com.devon.refferal.entites.User;
import com.devon.refferal.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception
	{
		String userName = jwtRequest.getUserName();
		String userPassword = jwtRequest.getUserPassword();
		authenticate(userName, userPassword);
		final UserDetails userDetails = loadUserByUsername(userName);
		
		String newGeneratedToken = jwtUtil.generateToken(userDetails);
		
		Role role = new Role();
		User user = userRepository.findById(userName).get();
		UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
		userDTO.setRolename(user.getRole().stream().findFirst().get().getRolename());
		return new JwtResponse(userDTO, newGeneratedToken);
	
	}
	
	/*
	 * public List<UserDTO> getAllUsers() { return ((List<User>) userRepository
	 * .findAll()) .stream() .map(this::convertToUserDTO)
	 * .collect(Collectors.toList()); }
	 */
	
	/*
	 * private UserDTO convertToUserDTO(User user) { UserDTO userDTO = new
	 * UserDTO(); userDTO.setName(user.getName());
	 * userDTO.setEmail(user.getEmail()); return userDTO; }
	 */


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user =  userRepository.findById(username).get();
		
		if(user != null) {
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user));
		}else {
			throw new UsernameNotFoundException("UserName not valid");
		}
		
	}
	
	private Set getAuthorities(User user)
	{
		Set authorities = new HashSet();
		user.getRole().forEach(role ->{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRolename()));
		}
		);
		return authorities;
		
		
	}
	
	private void authenticate(String userName, String userPassword) throws Exception 
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
		}catch(DisabledException e){
			throw new Exception("User is Disabled");
		}catch (BadCredentialsException e)
		{
			throw new Exception("Bad credentials from User");
		}
	}

}
