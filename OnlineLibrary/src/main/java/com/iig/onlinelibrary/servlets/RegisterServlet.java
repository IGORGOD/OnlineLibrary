package com.iig.onlinelibrary.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.iig.onlinelibrary.model.User;

/**
 * Servlet implementation class RegisterServlet. Servlet that serves register
 * page that provides register function.
 * 
 * @author Ihor I Great
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/JSP/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("password1").equals(request.getParameter("password2"))) {
			request.setAttribute("password", request.getAttribute("password1"));
			request.removeAttribute("password1");
			request.removeAttribute("password2");
			List<User> users = User.SERVICE.getAll();
			User user = new User();
			user.setName(request.getParameter("login"));
			if (!users.isEmpty()) {
				for (User usr : users) {
					if (usr.getName().equals(user.getName())) {
						session.setAttribute("reason", "User with same login already exsist!");
						getServletContext().getRequestDispatcher("/JSP/registererror.jsp").forward(request, response);
						break;
					}
				}
			}
			user.setHexPassword(DigestUtils.md5Hex(request.getParameter("password")));
			User.SERVICE.create(user);
			getServletContext().getRequestDispatcher("/signin").forward(request, response);
		}
		session.setAttribute("reason", "Wrong fields values!");
		getServletContext().getRequestDispatcher("/JSP/registererror.jsp").forward(request, response);
	}

}
