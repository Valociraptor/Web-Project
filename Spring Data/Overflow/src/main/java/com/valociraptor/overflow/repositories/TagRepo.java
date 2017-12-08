package com.valociraptor.overflow.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.valociraptor.overflow.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long>{
	
	Tag findBySubject(String subject);
	
	
}
