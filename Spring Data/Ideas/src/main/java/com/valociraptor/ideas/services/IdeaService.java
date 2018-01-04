package com.valociraptor.ideas.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.valociraptor.ideas.models.Idea;
import com.valociraptor.ideas.repositories.IdeaRepo;

@Service
public class IdeaService {

	private IdeaRepo ideaRepo;
	
	public IdeaService(IdeaRepo ideaRepo) {
		this.ideaRepo = ideaRepo;
	}
		
	public List<Idea> getAll() {

		return ideaRepo.findAllByOrderByLikeCountDesc();
	}

	public void createIdea(Idea idea) {
		ideaRepo.save(idea);
		
	}

	public Idea getIdea(Long id) {
		
		return ideaRepo.findOne(id);
	}

	public void update(Idea idea) {
		ideaRepo.save(idea);
		
	}
	@Transactional
	public void deleteIdea(Long id) {
		ideaRepo.deleteById(id);
		
	}

}
