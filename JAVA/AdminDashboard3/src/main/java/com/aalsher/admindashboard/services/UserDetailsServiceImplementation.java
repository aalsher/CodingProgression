package com.aalsher.admindashboard.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aalsher.admindashboard.models.Role;
import com.aalsher.admindashboard.models.User;
import com.aalsher.admindashboard.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{
	private UserRepository userRepository;

	public UserDetailsServiceImplementation(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	private List<GrantedAuthority> getAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role: user.getRoles()){
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			authorities.add(grantedAuthority);
		}
		return authorities;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null){throw new UsernameNotFoundException("User not found.");}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),getAuthorities(user));
	}

}