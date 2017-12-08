package com.valociraptor.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.valociraptor.dojos.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {

	List<Ninja> findByDojo_Id(Long id);
	List<Ninja> findAll();

}
