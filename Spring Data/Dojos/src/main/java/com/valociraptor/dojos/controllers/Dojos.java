package com.valociraptor.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valociraptor.dojos.models.Dojo;
import com.valociraptor.dojos.models.Ninja;
import com.valociraptor.dojos.services.DojoService;

@Controller
public class Dojos {
	
	private final DojoService dojoService;
	
	public Dojos(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		
		return "newdojo.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		
		return "newninja.jsp";
	}
	
	@RequestMapping("/dojos/{id}")
	public String dojos(Model model, @PathVariable("id") Long id) {
		Dojo dojo = dojoService.findDojo(id);
		
		model.addAttribute("ninjas", dojoService.ninjasInDojo(dojo));
		model.addAttribute("dojo", dojoService.findDojo(id));
		
		return "dojodetail.jsp";
	}
	
	@RequestMapping("/allninjas/{pageNumber}")
	public String allninjas(Model model, @PathVariable("pageNumber") int pageNumber) {
		Page<Ninja> ninjas = dojoService.ninjasPerPage(pageNumber -1);
		int totalPages = ninjas.getTotalPages();
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("ninjas", ninjas);
			
		return "ninjapage.jsp";
	}
	
	
	@PostMapping("/dojos")
	public String addDojo(@Valid @ModelAttribute Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newdojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@PostMapping("/ninjas")
		public String addNinja(@Valid @ModelAttribute Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "newninja.jsp";
		} else {
			Ninja ninj = dojoService.createNinja(ninja);
			String dojoId = Long.toString(ninj.getDojo().getId());
			return "redirect:/dojos/".concat(dojoId);
		}
		
	}
	

}
