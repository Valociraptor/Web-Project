package com.valociraptor.water.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.valociraptor.water.models.Role;
import com.valociraptor.water.models.User;
import com.valociraptor.water.repositories.RoleRepo;
import com.valociraptor.water.repositories.UserRepo;

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
    public void saveWithGuestRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_GUEST"));
        user.setIsHost(false);
        userRepo.save(user);
    }
     
     // 2 
    public void saveUserWithHostRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_HOST"));
        user.setIsHost(true);
        userRepo.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    
    public List<User> getAllUsers(){
    	return userRepo.findAll();
    }
    
    public Boolean hostCheck(){
    	List<Role> hosts = roleRepo.findByName("ROLE_HOST");
    	
    	for (Role item : hosts) {
	    	if (item.getUsers().size() == 0) {
	   
	    		return false;
	    	}
	    	else {

	    		return true;
	    	}
    	}
    	return false;
    }
    
    
    
    public Boolean roleCheck(User user) {
    	return user.getIsHost();
    	
    }
    
    public User getUser(Long id) {
    	return userRepo.findOne(id);
    }

	public void delete(Long id) {
		userRepo.delete(id);
		
	}
	
	public void makeAdmin(Long id) {
		User user = userRepo.findOne(id);
		
		user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
		user.setIsHost(true);
		userRepo.save(user);
		
			
	}
	

		
		
}


