package com.valociraptor.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valociraptor.languages.models.Language;
import com.valociraptor.languages.services.LanguageService;

@Controller
public class Languages {
	
	private final LanguageService languageService;
	public Languages(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLangs();
		model.addAttribute("languages", languages);
		
		return "index.jsp";
	}
	
	
	@RequestMapping("/languages/edit/{id}")
	public String editLanguage(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLang(id);
		if (language !=null) {
			model.addAttribute("language", language);
			return "edit.jsp";
		}
		else {
			return "redirect:/languages";
		}
		
			
	}
	

	@RequestMapping("/languages/{id}")
	public String detail(Model model, @PathVariable("id") Long id) {
		Language languageGet = languageService.findLang(id);
		if (languageGet !=null) {
			model.addAttribute("language", languageGet);
			return "details.jsp";
		}
		else {
			return "redirect:/languages";
		}
	}
	
	
	
	@PostMapping("/languages/new")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		
        if (result.hasErrors()) {
            return "index.jsp";
        }
        else{
            languageService.addLanguage(language);
            return "redirect:/languages";
        }
		
	}
	
	@PostMapping("/languages/update/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        }else{
            languageService.updateLanguage( language);
            return "redirect:/languages";
        }
	}
	
	
	@RequestMapping("/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLang(id);
		
		return "redirect:/languages";
	}


}
