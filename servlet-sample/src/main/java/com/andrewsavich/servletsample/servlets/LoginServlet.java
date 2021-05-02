package com.andrewsavich.servletsample.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrewsavich.servletsample.model.User;
import com.andrewsavich.servletsample.services.UserService;
import com.andrewsavich.servletsample.services.impl.ListUserService;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String password = req.getParameter("password");

		UserService service = ListUserService.getService();

		User userByLogin = service.getUserByLogin(login);

		if (userByLogin == null || !userByLogin.getPassword().equals(password)) {
			req.setAttribute("userNotFound", "true");
			req.getServletContext().getRequestDispatcher("/").forward(req, resp);
		}

		req.getSession().setAttribute("user", userByLogin);
		req.getServletContext().getRequestDispatcher("/list").forward(req, resp);
	}
}
