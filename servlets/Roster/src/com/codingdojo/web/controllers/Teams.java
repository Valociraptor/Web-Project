package com.codingdojo.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingdojo.web.models.Roster;
import com.codingdojo.web.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamId = request.getParameter("id");
		
		if(teamId == null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NewTeam.jsp");
			view.forward(request, response);
		} else {
			int id = Integer.valueOf(teamId);
			request.setAttribute("teamId", teamId);
			request.setAttribute("team", Roster.allTeams.get(id));
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/TeamInfo.jsp");
			view.forward(request, response);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teamName = request.getParameter("name");
		Team t = new Team(teamName);
		Roster.allTeams.add(t);
		response.sendRedirect("/Roster/Home");
	}

}
