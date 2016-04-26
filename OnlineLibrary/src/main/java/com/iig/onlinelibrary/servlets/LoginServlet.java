package com.iig.onlinelibrary.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.iig.onlinelibrary.crud.Service;
import com.iig.onlinelibrary.model.User;

/**
 * Servlet implementation class LoginServlet. Servlet that serves sign in page
 * and dispatches login.jsp and provides login function.
 * 
 * @author Ihor I Great
 *
 */
@WebServlet("/signin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/JSP/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Service<User> s = new Service<User>(new User());
		List<User> users = s.getAll();
		User user = new User();
		user.setName(request.getParameter("login"));
		user.setHexPassword(DigestUtils.md5Hex(request.getParameter("password")));
		if (!users.isEmpty()) {
			for (User usr : users) {
				if (usr.isUser(usr)) {
					getServletContext().getRequestDispatcher("/").forward(request, response);
					break;
				}
			}
		}
		getServletContext().getRequestDispatcher("/JSP/loginerror.jsp").forward(request, response);
	}

}
