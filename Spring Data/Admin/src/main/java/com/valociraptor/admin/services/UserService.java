package com.valociraptor.admin.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.valociraptor.admin.models.Role;
import com.valociraptor.admin.models.User;
import com.valociraptor.admin.repositories.RoleRepo;
import com.valociraptor.admin.repositories.UserRepo;

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
        user.setIsAdmin(false);
        userRepo.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
        user.setIsAdmin(true);
        userRepo.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    
    public List<User> getAllUsers(){
    	return userRepo.findAll();
    }
    
    public Boolean adminCheck(){
    	List<Role> admins = roleRepo.findByName("ROLE_ADMIN");
    	
    	for (Role item : admins) {
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
    	return user.getIsAdmin();
    	
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
		user.setIsAdmin(true);
		userRepo.save(user);
		
			
	}
	

		
		
}


