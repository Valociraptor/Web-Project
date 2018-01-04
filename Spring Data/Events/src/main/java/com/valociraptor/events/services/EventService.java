package com.valociraptor.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valociraptor.events.models.Event;
import com.valociraptor.events.models.User;
import com.valociraptor.events.repositories.EventRepo;
import com.valociraptor.events.repositories.UserRepo;

@Service
public class EventService {
	
	private final EventRepo eventRepo;
	private UserRepo userRepo;
	
	public EventService(EventRepo eventRepo, UserRepo userRepo) {
		this.eventRepo = eventRepo;
		this.userRepo = userRepo;
	}

	public List<Event> nonStateEvents(String state) {
		
		return eventRepo.findByStateNotIn(state);
	}

	public List<Event> stateEvents(String state) {
		
		return eventRepo.findByState(state);
	}

	public void createEvent(Event event) {
		eventRepo.save(event);
		
	}

	public Event findOne(Long id) {
		return eventRepo.findOne(id);
	}

	public void attendEvent(User user, Long id) {
		Event event = eventRepo.findOne(id);
		user.getAttendedEvents().add(event);
		userRepo.save(user);
		
	}

	public void cancel(User user, Long id) {
		Event event = eventRepo.findOne(id);
		user.getAttendedEvents().remove(event);
		userRepo.save(user);
		
	}
	
	
	

}
