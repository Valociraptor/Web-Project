package com.valociraptor.ideas.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.valociraptor.ideas.models.User;
import com.valociraptor.ideas.repositories.RoleRepo;
import com.valociraptor.ideas.repositories.UserRepo;

@Service
public class UserService {
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
    	this.userRepo = userRepo;
    	this.roleRepo = roleRepo;
    	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_USER"));
        userRepo.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
        userRepo.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

	public User getUser(Long id) {
		
		return userRepo.findOne(id);
	}

	public void update(User user) {
		userRepo.save(user);
		
	}

}
