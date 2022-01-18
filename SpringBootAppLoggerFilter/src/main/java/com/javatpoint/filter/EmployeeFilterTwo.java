package com.javatpoint.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.javatpoint.controller.EmployeeController;

@WebFilter("/log")
public class EmployeeFilterTwo implements Filter {

	Logger logger = LoggerFactory.getLogger(EmployeeFilterTwo.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("Creted EmployeeFilterTwo Filter class");
		/*
		 * logger.info("Local Port number : " + request.getServerPort());
		 * logger.info("Server Name : " + request.getServerName());
		 * logger.info("Protocol : " + request.getProtocol()); HttpServletRequest
		 * httpServletRequest = (HttpServletRequest) request; logger.info("Method : " +
		 * httpServletRequest.getMethod()); logger.info("Request URI : " +
		 * httpServletRequest.getRequestURI()); logger.info("Servlet Path : " +
		 * httpServletRequest.getServletPath());
		 */
		chain.doFilter(request, response);

	}

}
