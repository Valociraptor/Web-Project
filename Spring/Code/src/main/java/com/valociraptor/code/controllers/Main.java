package com.valociraptor.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Main {
	
	@RequestMapping("/")
	public String index(@ModelAttribute("errors") String errors) {
		
		return "index.jsp";
	}
	
	
	@RequestMapping(path="/validate", method=RequestMethod.POST)
	public String validate(@RequestParam (value="code") String code, RedirectAttributes redirectAttributes) {
		
		if (code.equals("bushido")) {
			
			return "redirect:/code";
		}
		
		
		else {
			redirectAttributes.addFlashAttribute("errors", "THAT'S NOT THE CODE YOU STUPID DUMB, IDIOT!");
		}
		return "redirect:/";
		
	}
	
	
	@RequestMapping("/code")
	public String secret() {
		
		return "secret.jsp";
	}

}
