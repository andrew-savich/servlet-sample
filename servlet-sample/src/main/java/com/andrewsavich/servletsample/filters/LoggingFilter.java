package com.andrewsavich.servletsample.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingFilter implements Filter {
	
	private String path;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		path = filterConfig.getInitParameter("path");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		log.info("Filter is invoken for path: " + path);
		chain.doFilter(request, response);
	}

}
