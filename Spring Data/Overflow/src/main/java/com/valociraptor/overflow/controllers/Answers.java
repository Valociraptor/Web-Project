package com.valociraptor.overflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.valociraptor.overflow.models.Answer;
import com.valociraptor.overflow.services.AnswerService;

@Controller
public class Answers {
	
	private final AnswerService answerService; 
	
	public Answers(AnswerService answerService){
		this.answerService = answerService;
	}
	
	@PostMapping("/answers")
	public String answers(@Valid @ModelAttribute("answerModel") Answer answer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question", answer.getQuestion());
			return "/question.jsp";
		} else {
			answerService.createAnswer(answer);
			String questionId = String.valueOf(answer.getQuestion().getId());
			return "redirect:/questions/".concat(questionId);
		}
		
		
	}

}
	