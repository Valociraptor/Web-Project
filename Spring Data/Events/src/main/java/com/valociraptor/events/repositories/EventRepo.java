package com.valociraptor.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.valociraptor.events.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long>{

	List<Event> findByStateNotIn(String state);

	List<Event> findByState(String state);

}
