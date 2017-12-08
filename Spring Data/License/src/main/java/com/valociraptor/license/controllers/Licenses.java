package com.valociraptor.license.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valociraptor.license.models.License;
import com.valociraptor.license.models.Person;
import com.valociraptor.license.services.LicenseService;

@Controller
public class Licenses {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	private final LicenseService dmv;
	
	public Licenses(LicenseService dmv) {
		this.dmv = dmv;
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute License license, Model model) {
		model.addAttribute("persons", dmv.allPersons());
		return "newlicense.jsp";
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newperson.jsp";
	}
	
	
	@PostMapping("/persons")
	public String newPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newperson.jsp";
		} else {
			dmv.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	
	@PostMapping("/licenses")
	public String createLicense(Model model) {
		if(result.hasErrors()) {
			model.addAttribute("persons", dmv.allPersons());
			return "newlicense.jsp";
		} else {
			License lic = dmv.createLicense(license);
			String personId = Long.toString(lic.getPerson().getId());
			return "redirect:/persons/".concat(personId);
		}
	}
	
	@RequestMapping("persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", dmv.getPerson(id));
		return "/person.jsp";
	}

}
