package com.iig.onlinelibrary.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OlServlet. Servlet that serves hello page and
 * dispatches hello.jsp
 * 
 * @author Ihor I Great
 *
 */
@WebServlet("/hello")
public class OlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/JSP/hello.jsp").forward(request, response);
	}
}
