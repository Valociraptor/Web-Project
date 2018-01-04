package com.valociraptor.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valociraptor.events.models.Message;
import com.valociraptor.events.repositories.MessageRepo;

@Service
public class MessageService {
	private final MessageRepo messageRepo;
	
	public MessageService(MessageRepo messageRepo) {
		this.messageRepo = messageRepo;
	}

	public List<Message> eventMessages(Long id) {
		
		return messageRepo.findByEventId(id);
	}

	public void createMessage(Message message) {
		messageRepo.save(message);
		
	}

}
