package com.javatpoint.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.controller.EmployeeController;

@Component
public class EmployeeInterceptor implements HandlerInterceptor {

	Logger logger = LoggerFactory.getLogger(EmployeeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("EmployeeInterceptor - preHandle");
		boolean flag = true;
		String method = request.getMethod();

		if (method.equalsIgnoreCase("post") || method.equalsIgnoreCase("put")) {
			String ContentType = request.getContentType();
			if (ContentType.equalsIgnoreCase("application/json") || ContentType != null) {
				flag = false;
			}
		}

		if (!flag) {
			response.sendRedirect("/invalid");
		}
		return flag;
		// return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("EmployeeInterceptor - postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("EmployeeInterceptor - afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
