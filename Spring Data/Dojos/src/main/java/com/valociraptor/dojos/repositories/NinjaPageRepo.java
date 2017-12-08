package com.valociraptor.dojos.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.valociraptor.dojos.models.Ninja;

@Repository
public interface NinjaPageRepo extends PagingAndSortingRepository<Ninja, Long>{

}
