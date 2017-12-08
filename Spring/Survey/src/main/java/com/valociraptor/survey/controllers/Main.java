package com.valociraptor.survey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {
	
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	

	
	@RequestMapping (path="/", method=RequestMethod.POST)
	public String processForm(
			@RequestParam (value="name") String name, 
			@RequestParam (value="location") String location, 
			@RequestParam (value="language") String language, 
			@RequestParam (value="comment") String comment, 
			HttpSession session 
			) {
		
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		
		
		return "redirect:/results";
	}
	
	
	@RequestMapping ("/results")
	public String result(HttpSession session) {
		
		return "result.jsp";
	}

}
