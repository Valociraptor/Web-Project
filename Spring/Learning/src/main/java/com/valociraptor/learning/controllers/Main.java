package com.valociraptor.learning.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	
	@RequestMapping("/")
	public String index() {
		return "lesson.jsp";
	}
	
	
	@RequestMapping("/m/{chapter}/0553/{assignmentId}")
	public String lesson(@PathVariable String chapter, @PathVariable String assignmentId, Model model) {
		
		String desc = "";
		
		if (assignmentId.equals ("0733")) {
			desc = "Setting up your servers";
		}
		
		else if (assignmentId.equals("0342")) {
			desc = "Punch Cards";
		}
		
		else if (assignmentId.equals("0348")){
			desc = "Advanced Fortran Intro";
		}
		
		else {
			desc = "placeholder";
		}
		
		model.addAttribute("desc", desc);
		
		return "lesson.jsp";
	}
		
	
	@RequestMapping("/m/{chapter}/0483/{assignmentId}")
	public String assignment(@PathVariable String chapter, @PathVariable String assignmentId, Model model) {
		
		String desc = "";
		
		if (assignmentId.equals("0345")) {
			desc = "Coding Forms";
		}
		
		else if (assignmentId.equals("2342")){
			desc = "Fortran to Binary";
		}
		else {
			desc = "placeholder";
		}
		
		model.addAttribute("desc", desc);
		
		return "assignment.jsp";
	}
	
	

}
