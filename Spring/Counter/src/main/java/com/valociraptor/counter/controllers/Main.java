package com.valociraptor.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
		@RequestMapping("/")
		public String indexy(HttpSession session) {		
			Integer count = (Integer) session.getAttribute("count");		
			if (count == null){
				session.setAttribute("count", 0);
			}
			else {
				count++;		
				session.setAttribute("count", count);		
			}
			return "index.jsp";
		}
		
		@RequestMapping("/counter")
		public String county(HttpSession session) {
			
			return "counter.jsp";
		}
		
		
		
}
