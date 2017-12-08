package com.valociraptor.overflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valociraptor.overflow.models.Question;
import com.valociraptor.overflow.repositories.QuestionRepo;


@Service
public class QuestionService {
	
	private final QuestionRepo questionRepo;
	
	
	public QuestionService(QuestionRepo questionRepo) {
		this.questionRepo = questionRepo;
		
	}
	
	public List<Question> allQuestions(){
		return questionRepo.findAll();
	}

	public void createQuestion(Question question) {
		questionRepo.save(question);
		
	}

	public Question getQ(Long id) {
		return questionRepo.findOne(id);
		
	}
	
	

}
