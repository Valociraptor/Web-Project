package com.valociraptor.events.controllers;

import java.security.Principal;
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

import com.valociraptor.events.models.Event;
import com.valociraptor.events.models.Message;
import com.valociraptor.events.models.User;
import com.valociraptor.events.services.EventService;
import com.valociraptor.events.services.MessageService;
import com.valociraptor.events.services.UserService;

@Controller
@RequestMapping("/events")
public class Events {
	private final EventService eventService;
	private final UserService userService;
	private final MessageService messageService;
	
	public Events(EventService eventService, UserService userService, MessageService messageService) {
		this.eventService = eventService;
		this.userService = userService;
		this.messageService = messageService;
	}
	
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	@RequestMapping("")
    public String home(Principal principal, Model model, @ModelAttribute("event") Event event) {
        // 1
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        String state = currentUser.getState();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("states", userService.states());
        model.addAttribute("nonStateEvents", eventService.nonStateEvents(state));
        model.addAttribute("stateEvents", eventService.stateEvents(state));
        return "eventDashboard.jsp";
    }
    
	
	@PostMapping("/new")
	public String newEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model) {
		model.addAttribute("states", userService.states());
        if (result.hasErrors()) {
        	
            return "eventDashboard.jsp";
        }
        eventService.createEvent(event);

        return "redirect:/events";
	}
	
	@RequestMapping("/{id}")
	public String eventDetail(@PathVariable("id") Long id, Principal principal, @ModelAttribute("message") Message message, Model model) {
        String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("event", eventService.findOne(id));
		model.addAttribute("messages", messageService.eventMessages(id));
		return "eventDetail.jsp";
	}
	
	@PostMapping("/{id}/newmessage")
	public String newMessage(@Valid @ModelAttribute("message") Message message, BindingResult result, @PathVariable("id") Long id, Principal principal, Model model) {
		String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		if (result.hasErrors()) {
			model.addAttribute("event", eventService.findOne(id));
			model.addAttribute("messages", messageService.eventMessages(id));
			model.addAttribute("currentUser", currentUser);
	        return "eventDetail.jsp";
	        }
	    messageService.createMessage(message);
		
		return "redirect:/events/"+id;
		
	}
	
	
	
	@RequestMapping("/{id}/join")
	public String joinEvent(@PathVariable("id") Long id, Principal principal) {
        String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		eventService.attendEvent(currentUser, id);
		return "redirect:/events";
	}
	
	
	@RequestMapping("/{id}/edit")
	public String editEventForm(@PathVariable("id") Long id, Principal principal, @ModelAttribute("event") Event event, Model model) {
		
        String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		Event thisEvent = eventService.findOne(id);
		if (currentUser != thisEvent.getUser() ) {
			return "redirect:/events";
		}
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("event", thisEvent);
		model.addAttribute("states", userService.states());
		return "editEvent.jsp";
	}
	
	@PostMapping("/{id}/edit")
	public String editEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, @PathVariable("id") Long id, Principal principal) {
        if (result.hasErrors()) {
            String username = principal.getName();
    		User currentUser = userService.findByUsername(username);
    		model.addAttribute("currentUser", currentUser);
    		model.addAttribute("event", eventService.findOne(id));
    		model.addAttribute("states", userService.states());
            return "editEvent.jsp";
        }
        eventService.createEvent(event);

        return "redirect:/events";
	}
	
	@RequestMapping("/{id}/cancel")
	public String cancel( @PathVariable("id") Long id, Principal principal) {
        String username = principal.getName();
		User currentUser = userService.findByUsername(username);
		
		eventService.cancel(currentUser, id);
		return "redirect:/events";
		
	}

}
