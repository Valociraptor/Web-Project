package com.valociraptor.admin.controllers;

import java.security.Principal;

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

import com.valociraptor.admin.models.User;
import com.valociraptor.admin.services.UserService;
import com.valociraptor.admin.validator.UserValidator;

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
    	
    	return "registrationPage.jsp";
    }
    
    @RequestMapping("/dashboard")
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        if (userService.findByUsername(username).getIsAdmin()) {
        	return "redirect:/admin";
        }
        return "dashboard.jsp";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
        	userValidator.validate(user, result);
            return "registrationPage.jsp";
        }
        Boolean check = userService.adminCheck();
        if (check) {
        	userService.saveWithUserRole(user);
        	return "redirect:/";
        }
        else {
        	userService.saveUserWithAdminRole(user); 
        
        	return "redirect:/";
        }
        
        
        
    }
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("users", userService.getAllUsers());
        return "adminPage.jsp";
    }
    
    @RequestMapping("admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
    	User user = userService.getUser(id);
    	Boolean isAdmin = user.getIsAdmin();
    	if (isAdmin) {
    		return "redirect:/admin";
    	}
    	userService.delete(id);
    	
    	return "redirect:/admin";
    }
    
    @RequestMapping("admin/makeAdmin/{id}")
    public String makeAdmin(@PathVariable("id") Long id) {
    	userService.makeAdmin(id);
    	return "redirect:/admin";
    }
    
    
    

}
