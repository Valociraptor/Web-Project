package com.valociraptor.date.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dat")
	public String date(Model model) {
		String pattern = "EEEEE, 'the' d 'of' MMMMM, yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		model.addAttribute("date", date);
		return "date.jsp";
	}
	
	
	@RequestMapping("/tim")
	public String time(Model model) {
		String pattern = "hh:mm aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String time = simpleDateFormat.format(new Date());
		model.addAttribute("time", time);
		return "time.jsp";
	}


}
