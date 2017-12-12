package com.valociraptor.admin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.valociraptor.admin.models.Role;

public interface RoleRepo extends CrudRepository<Role, Long> {
    List<Role> findAll();
    
    List<Role> findByName(String name);
}
