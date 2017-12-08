package com.valociraptor.license.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.valociraptor.license.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	
}
