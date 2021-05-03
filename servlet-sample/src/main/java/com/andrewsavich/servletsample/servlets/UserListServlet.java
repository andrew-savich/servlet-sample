package com.andrewsavich.servletsample.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrewsavich.servletsample.model.User;
import com.andrewsavich.servletsample.services.impl.ListUserService;

@WebServlet(urlPatterns = { "/userList" })
public class UserListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<User> allUsers = ListUserService.getService().getAllUsers();
		System.out.println(allUsers);

		for (User user : allUsers) {
			System.out.println(user);
		}

		req.setAttribute("users", allUsers);

		req.getServletContext().getRequestDispatcher("/list.jsp").forward(req, resp);

	}

}
