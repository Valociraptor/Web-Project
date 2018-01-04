package com.valociraptor.water.controllers;

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

import com.valociraptor.water.models.User;
import com.valociraptor.water.services.UserService;
import com.valociraptor.water.validator.UserValidator;

@Controller
public class Users {
    private UserService userService;
    private UserValidator userValidator;
    
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
	
	
    @RequestMapping("/registration")
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
//        if (userService.findByUsername(username).getIsHost()) {
//        	return "redirect:/host";
//      }
        return "dashboard.jsp";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
        	userValidator.validate(user, result);
            return "registrationPage.jsp";
        }
        Boolean check = userService.hostCheck();
        if (check) {
        	userService.saveWithGuestRole(user);
        	return "redirect:/";
        }
        else {
        	userService.saveUserWithHostRole(user); 
        
        	return "redirect:/";
        }
        
        
        
    }
    
//    @RequestMapping("/host")
//    public String adminPage(Principal principal, Model model) {
//        String username = principal.getName();
//        model.addAttribute("currentUser", userService.findByUsername(username));
//        model.addAttribute("users", userService.getAllUsers());
//        return "hostPage.jsp";
//    }
//    
//    @RequestMapping("host/delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id) {
//    	User user = userService.getUser(id);
//    	Boolean isAdmin = user.getIsHost();
//    	if (isAdmin) {
//    		return "redirect:/host";
//    	}
//    	userService.delete(id);
//    	
//    	return "redirect:/host";
//    }

    

}
