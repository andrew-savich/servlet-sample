package com.andrewsavich.servletsample.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andrewsavich.servletsample.services.impl.ListUserService;

@WebServlet(urlPatterns = "/admin/userdelete")
public class UserDeletionServlet extends HttpServlet {

	private static final long serialVersionUID = 2770416371575657450L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String parameter = req.getParameter("id");
		Integer userId = Integer.valueOf(parameter);

		ListUserService.getService().deleteUser(userId);

		req.getServletContext().getRequestDispatcher("/userList").forward(req, resp);

	}

}
