package com.valociraptor.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
//	@RequestMapping("/")
//	public String index() {
//		return "index.html";
//	}
//	
//	@RequestMapping("/project")
//	public String project() {
//		return "projects.html";
//	}
//	
//	
//	@RequestMapping("/m")
//	public String me() {
//		return "me.html";
//	}
//	
	@RequestMapping("/jasper")
	public String sjpr(Model model) {
		model.addAttribute("name", "VAL!");
		return "index.jsp";
	}
	
	
	
	

}
