package com.valociraptor.ideas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valociraptor.ideas.models.User;
import com.valociraptor.ideas.services.UserService;
import com.valociraptor.ideas.validator.UserValidator;

@Controller
public class Users {
    private UserService userService;
    private UserValidator userValidator;
    
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
	
	
    @RequestMapping("/main")
    public String registerForm(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model,  @ModelAttribute("user") User user) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successfull!");
        }        
    	
    	return "registrationPage.jsp";
    }
    

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
        	
            return "registrationPage.jsp";
        }
        userService.saveWithUserRole(user);
        model.addAttribute("errorMessage", "Registration Successful!  Please log in below.");
        return "redirect:/main";
    }
    
    @RequestMapping("/users/{id}")
    public String userDetail(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("user", userService.getUser(id));
    	return "userDetail.jsp";
    }
    
}

    