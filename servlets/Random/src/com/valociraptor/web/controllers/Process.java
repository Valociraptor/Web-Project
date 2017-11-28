package com.valociraptor.web.controllers;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Process
 */
@WebServlet("/Process")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Process() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String word = (String)session.getAttribute("word");
		if (word == null) {
			session.setAttribute("word", "None");
		}
		else {
		    String r = "";
		    for(int i = 0; i < 10; i++) {
		        r += (char)(Math.random() * 26 + 97);
		    }
		    
		    session.setAttribute("word", r);
		   
		}
		
		
		String time = (String) session.getAttribute("time");
		if (time == null) {
			session.setAttribute("time", "Never");
		}
		
		else {
			Date t = new Date();
			
			Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String v = formatter.format(t);
			
			session.setAttribute("time", v);
		}
		
		
		
        Integer count = (Integer)session.getAttribute("count");
        if (count == null) {
        	session.setAttribute("count", 0);
        }
        else {
        	Integer count1 = (Integer) session.getAttribute("count");
            count1++;
            session.setAttribute("count", count1);
        }
        
        
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/randomword.jsp");
        view.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
