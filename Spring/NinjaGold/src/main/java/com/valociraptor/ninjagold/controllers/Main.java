package com.valociraptor.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		
		Integer gold = (Integer) session.getAttribute("totalgold");
		ArrayList<String> logs = (ArrayList<String>) session.getAttribute("logs");
		
		if (gold == null) {
			gold = 0;
			session.setAttribute("totalgold", gold);
		}		
		
		
		if (logs == null) {
			session.setAttribute("logs", new ArrayList<String>());
		}
		
		return "index.jsp";
				
		
	}
	
	@RequestMapping (path="/process", method=RequestMethod.POST)
	public String process(@RequestParam (value="building") String building, HttpSession session ) {
		
		Integer gold = (Integer) session.getAttribute("totalgold");		
		ArrayList<String> logs = (ArrayList<String>) session.getAttribute("logs");
		
		String pattern = "MMMMM d, yyyy, hh:mm:ss aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		
		if (building.equals("farm")) {
			Random random = new Random();
			int num = random.nextInt(5) + 1;
			gold += num;
			
			
			logs.add(0, "You got "+num+" gold from the farm!" + "("+ date + ")");
		}
		
		else if (building.equals("cave")) {
			Random random = new Random();
			int num = random.nextInt(10) + 11;
			gold += num;
			
			logs.add(0, "You got "+num+" gold from the cave!"+ "("+ date + ")");
		}
		
		else if (building.equals("house")) {
			Random random = new Random();
			int num = random.nextInt(3) + 3;
			gold += num;
			
			logs.add(0, "You got "+num+" gold from the house!"+ "("+ date + ")");
		}
		
		else  if (building.equals("casino")){
			Random random = new Random();
			int num = random.nextInt(2);
			System.out.println(num);
			
			if (num == 0) {
				gold -= 50;
				
				logs.add("Suckah!  You just lost 50 gold at the Casino  ;_; "+ "("+ date + ")");
			}
			else {
				gold += 50;
				
				logs.add(0, "NOICE!  You just won 50 gold at the Casino!!"+ "("+ date + ")");
			}
		
			
		}
		
		session.setAttribute("totalgold", gold);
		session.setAttribute("logs", logs);

		
		return "redirect:/";
	}
	
	
	@RequestMapping (path="/clear", method=RequestMethod.POST)
	public String process(HttpSession session ) {
		
		session.invalidate();
		return "redirect:/";
	}

}
