package com.valociraptor.overflow.services;


import org.springframework.stereotype.Service;


import com.valociraptor.overflow.models.Tag;
import com.valociraptor.overflow.repositories.TagRepo;

@Service
public class TagService {
	
	private final TagRepo tagRepo;
	
	public TagService(TagRepo tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	
	public Tag findOrCreateTag(String subject) {
		Tag tagByName = tagRepo.findBySubject(subject); 
		if(tagByName == null) {
			Tag tag = new Tag();
			tag.setSubject(subject);
			return tagRepo.save(tag);
		} else {
			return tagByName;
		}
	}
	
	
	
	
}
