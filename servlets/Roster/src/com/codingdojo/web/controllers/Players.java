package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingdojo.web.models.Player;
import com.codingdojo.web.models.Roster;

/**
 * Servlet implementation class PLayers
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teamId = Integer.valueOf(request.getParameter("id"));
		String teamName = Roster.allTeams.get(teamId).getName();
		request.setAttribute("teamName", teamName);
		request.setAttribute("teamId", teamId);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NewPlayer.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teamId = Integer.valueOf(request.getParameter("teamId"));
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		int age = Integer.valueOf(request.getParameter("age"));
		Player p = new Player(fName, lName, age);
		Roster.allTeams.get(teamId).getPlayers().add(p);
		response.sendRedirect("/Roster/Teams?id=" + teamId);
	}

}
