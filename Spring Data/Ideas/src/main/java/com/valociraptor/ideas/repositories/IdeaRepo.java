package com.valociraptor.ideas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.valociraptor.ideas.models.Idea;

@Repository
public interface IdeaRepo extends CrudRepository<Idea, Long> {

	List<Idea> findAll();

	List<Idea> findAllByOrderByLikeCountDesc();

	void deleteById(Long id);

	

	

}
