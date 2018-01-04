package com.valociraptor.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.valociraptor.events.models.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long>{

	List<Message> findByEventId(Long id);

}
