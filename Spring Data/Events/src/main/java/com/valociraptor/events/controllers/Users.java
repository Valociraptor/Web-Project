package com.valociraptor.events.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valociraptor.events.models.User;
import com.valociraptor.events.services.UserService;
import com.valociraptor.events.validator.UserValidator;

@Controller
public class Users {
    private UserService userService;
    private UserValidator userValidator;
    
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
	
	
    @RequestMapping("/")
    public String registerForm(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model,  @ModelAttribute("user") User user) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successfull!");
        }        
        model.addAttribute("states", userService.states());
    	return "registrationPage.jsp";
    }
    
    

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
        	userValidator.validate(user, result);
            return "registrationPage.jsp";
        }
        userService.saveWithUserRole(user);
        model.addAttribute("errorMessage", "Registration Successful!  Please log in below.");

        return "redirect:/";
    }
    

    
    
    

}
