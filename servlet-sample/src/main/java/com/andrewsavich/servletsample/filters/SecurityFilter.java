package com.andrewsavich.servletsample.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.andrewsavich.servletsample.model.Role;
import com.andrewsavich.servletsample.model.User;

@WebFilter(urlPatterns = "/admin/*")
public class SecurityFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) request).getSession();

		User user = (User) session.getAttribute("user");

		if (user == null) {
			request.getServletContext().getRequestDispatcher("/").forward(request, response);
		}

		if (user.getRole().equals(Role.ADMIN)) {
			chain.doFilter(request, response);
		}

		request.setAttribute("noPerm", "true");
		request.getServletContext().getRequestDispatcher("/userList").forward(request, response);

	}
}
