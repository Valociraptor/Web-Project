package com.valociraptor.ideas.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valociraptor.ideas.models.Idea;
import com.valociraptor.ideas.models.User;
import com.valociraptor.ideas.services.IdeaService;
import com.valociraptor.ideas.services.UserService;

@Controller
@RequestMapping("/bright_ideas")
public class Ideas {
	private UserService userService;
	private IdeaService ideaService;
	
	public Ideas(UserService userService, IdeaService ideaService) {
		this.userService = userService;
		this.ideaService = ideaService;
		
	}
	
    @RequestMapping("")
    public String dashboard(Principal principal, Model model, @ModelAttribute("idea") Idea idea) {
        String username = principal.getName();
        model.addAttribute("ideas", ideaService.getAll());
        
        
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "ideaDashboard.jsp";
    }
    
    @PostMapping("/new")
    public String newIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Principal principal, Model model) {
    	
        if (result.hasErrors()) {
            String username = principal.getName();
            model.addAttribute("ideas", ideaService.getAll());
            model.addAttribute("currentUser", userService.findByUsername(username));
            return "ideaDashboard.jsp";
        }
        ideaService.createIdea(idea);
        
        return "redirect:/bright_ideas";
    	
    }
    // Note: The wireframe seems to indicate that one idea can be liked by the same person multiple times, but
    //       that person should only appear in the list of users that liked a particular idea once.  So,
    //       I'm storing the number of likes an idea has as "likeCount" in the idea model, and then checking
    //		 the list of users who've liked an idea to see if they exist or not, before saving them to the list
    @RequestMapping("/like/{id}/")
    public String like(@PathVariable("id") Long id, Principal principal) {
    	String username = principal.getName();
    	User currentUser = userService.findByUsername(username);
    	Idea idea = ideaService.getIdea(id);
    	Long userLikeCount = currentUser.getLikeCount();
    	
    	
    	if(userLikeCount == null) {
    		userLikeCount = (long) 0;
    	}
    	userLikeCount++;
    	currentUser.setLikeCount(userLikeCount);
    	userService.update(currentUser);
    	
    	
    	Long likeCount = idea.getLikeCount();
    	if(likeCount == null) {
    		likeCount = (long) 0;
    	}
    	likeCount++;
    	idea.setLikeCount(likeCount);
    	ideaService.update(idea);
    	
    	
    	List<User> likers = idea.getLikers();
    	if(likers.contains(currentUser)) {
    		return "redirect:/bright_ideas";
    	}
    	else {
    		likers.add(currentUser);
    		idea.setLikers(likers);
    		ideaService.update(idea);
    		return "redirect:/bright_ideas";
    	}
    	
    }
    	
    @RequestMapping("/{id}")
    public String ideaDetail(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("idea", ideaService.getIdea(id));
    	return "ideaDetail.jsp";
    }
    
    @RequestMapping("/delete/{id}")
    public String ideaDelete(@PathVariable("id") Long id, Model model) {
    	
    	ideaService.deleteIdea(id);
    	return "redirect:/bright_ideas";
    }
    
    

}
