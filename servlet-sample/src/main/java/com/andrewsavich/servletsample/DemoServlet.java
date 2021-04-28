package com.andrewsavich.servletsample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String BODY = "<html>"
									+ "<head><title>JSP Page</title></head>" + "<body>"
									+ "<h2>This is JSP Page!</h2>"
									+ "</body"
									+ "</html>";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().write(BODY);
	}
}
