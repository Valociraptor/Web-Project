package com.valociraptor.userdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.valociraptor.userdemo.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	User findByUsername(String username);
}
