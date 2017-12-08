package com.valociraptor.overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valociraptor.overflow.models.Answer;
import com.valociraptor.overflow.models.Question;
import com.valociraptor.overflow.models.Tag;
import com.valociraptor.overflow.services.QuestionService;
import com.valociraptor.overflow.services.TagService;


@Controller

public class Questions {
	
	private final QuestionService questionService;
	private final TagService tagService;
	
	public Questions(QuestionService questionService, TagService tagService) {
		this.questionService = questionService;
		this.tagService = tagService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "tags", new CustomCollectionEditor(List.class) {                
	                  
	        public void setAsText(String element) {
	        	// information coming from the form
	        	String[] listOfTagString = element.split(", ");
	        	List<Tag> listOfTags = new ArrayList<Tag>();
	        	
	        	int maxLength = listOfTagString.length > 2 ? 3 : listOfTagString.length;
	        	
	        	for(int i = 0; i < maxLength; i++) {
	        		listOfTags.add(tagService.findOrCreateTag(listOfTagString[i]));
	        	}
	        	
	        	// set the value of the element to be a list of tags
	        	setValue(listOfTags);
	        }
        }); 
	}
	
	@RequestMapping("/questions")
	public String dashboard(Model model) {
		
		List<Question> questions = questionService.allQuestions();

		model.addAttribute("questions", questions);
		
		return "dashboard.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("questionModel") Question question) {
		
		return "newquestion.jsp";
	}
	
	
	@PostMapping("/questions/add")
	public String addQuestion(@Valid @ModelAttribute("questionModel") Question question, BindingResult result, @RequestParam("tags") String tags) {
		
		if(result.hasErrors()) {
			return "newquestion.jsp";
		} else {
			questionService.createQuestion(question);
			return "redirect:/questions/";
		}
	}
		
	
	@RequestMapping("/questions/{id}")
	public String answers(Model model, @ModelAttribute("answerModel") Answer answer, @PathVariable("id") Long id) {
		Question question = questionService.getQ(id);
		
		
		model.addAttribute("question", questionService.getQ(id));
		
		return "detail.jsp";
	}

	

	
	
	
	
}
