package com.valociraptor.login.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.valociraptor.login.models.Role;

public interface RoleRepo extends CrudRepository<Role, Long> {
    List<Role> findAll();
    
    List<Role> findByName(String name);
}
