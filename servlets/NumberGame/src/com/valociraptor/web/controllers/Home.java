package com.valociraptor.web.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/")
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
		HttpSession session = request.getSession();
		
		Integer answer = (Integer)session.getAttribute("answer");
		String highlow = "";

		
		if(answer == null ) {
			Random random = new Random();
			int num = random.nextInt(100) + 1;
			
			session.setAttribute("answer", num);
			session.setAttribute("highlow", highlow);
		}
		
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/numbers.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("You've reached the post method!");
		
		HttpSession session = request.getSession();
		
		Integer answer = (Integer)session.getAttribute("answer");
		Integer guess = Integer.parseInt(request.getParameter("guess"));
		String highlow = "";
		Integer reset = Integer.parseInt(request.getParameter("reset"));
	
		

		
		if(reset == 1 ) {
			Random random = new Random();
			int num = random.nextInt(100) + 1;
			
			reset = 0;
			session.setAttribute("answer", num);
		}
		
		else if (guess == 0) {
			highlow = "";
			session.setAttribute("highlow", highlow);
		}
		
		else if (guess > answer) {
			highlow = "Your guess was too high!  Try again!";
			session.setAttribute("highlow", highlow);
			
		}
		
		else if (guess < answer) {
			highlow = "Your guess was too low, Try again!";
			session.setAttribute("highlow", highlow);
		}
		
		else if (guess == answer) {
			highlow = "YAY!";
			session.setAttribute("highlow", highlow);
		}
			
		
		
		session.setAttribute("guess", guess);
			
		
		
		response.sendRedirect("/NumberGame");
	}

}
