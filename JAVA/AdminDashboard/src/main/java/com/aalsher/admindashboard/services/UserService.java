package com.aalsher.admindashboard.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aalsher.admindashboard.models.User;
import com.aalsher.admindashboard.repositories.RoleRepository;
import com.aalsher.admindashboard.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
	public List<User> all(){return (List<User>) userRepository.findAll();}
	public User getById(long id){return userRepository.findOne(id);}

    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
	    	List<Role> userRoles = new ArrayList<>();
	    	Role getRole = roleRepository.findByName("ROLE_USER");
	    	userRoles.add(getRole);
	    	Role getRole = roleRepository.findByName("ROLE_ADMIN");
	    	userRoles.add(getRole);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

