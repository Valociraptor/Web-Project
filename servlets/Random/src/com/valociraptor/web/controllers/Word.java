package com.valociraptor.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Word
 */
@WebServlet("/Word")
public class Word extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Word() {
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
		
		String time = (String) session.getAttribute("time");
		if (time == null) {
			session.setAttribute("time", "Never");
		}
		
		
        Integer count = (Integer)session.getAttribute("count");
        if (count == null) {
        	session.setAttribute("count", 0);
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
