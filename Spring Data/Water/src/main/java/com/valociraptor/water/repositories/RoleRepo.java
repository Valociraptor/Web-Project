package com.valociraptor.water.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.valociraptor.water.models.Role;

public interface RoleRepo extends CrudRepository<Role, Long> {
    List<Role> findAll();
    
    List<Role> findByName(String name);
}
