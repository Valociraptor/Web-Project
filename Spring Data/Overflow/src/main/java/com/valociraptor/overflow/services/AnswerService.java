package com.valociraptor.overflow.services;

import org.springframework.stereotype.Service;

import com.valociraptor.overflow.models.Answer;
import com.valociraptor.overflow.repositories.AnswerRepo;

@Service
public class AnswerService {
	
	private final AnswerRepo answerRepo;
	
	public AnswerService(AnswerRepo answerRepo) {
		this.answerRepo = answerRepo;
	}

	public void createAnswer(Answer answer) {
		answerRepo.save(answer);
		
	}

}
