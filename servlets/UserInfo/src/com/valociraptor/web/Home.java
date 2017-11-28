package com.valociraptor.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
// @WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = "Unknown";
		String location = "Unknown";
		String language = "Unknown";
		
		if (request.getParameter("name") != null) {
			name = request.getParameter("name");
		}


		if (request.getParameter("location") != null) {
			location = request.getParameter("location");
		}
		
		
		if (request.getParameter("language") != null) {
			language = request.getParameter("language");
		}
	
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<h1>Die in a fire " + name + "!</h1><h2>You are located at: " + location + "</h2><h2>Your preferred language is: " + language + "</h2>");
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
