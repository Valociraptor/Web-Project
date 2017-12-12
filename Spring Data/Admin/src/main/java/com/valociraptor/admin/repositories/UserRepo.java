package com.valociraptor.admin.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.valociraptor.admin.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	 User findByUsername(String username);
	 
	 List<User> findAll();

	 User findOne(Long id);
	
}
