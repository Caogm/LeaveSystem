package com.leavesystem.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*public class UserInterceptor extends HandlerInterceptorAdapter {*/
public class UserInterceptor implements HandlerInterceptor {

	//拦截前处理  
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		System.out.println("preHandle...." + request.getRequestURI());
		System.out.println(request.getSession().getAttribute("user"));
		if (request.getSession().getAttribute("user") != null) {
			// 判断用户名在session中是否存在，存在则放行
			return true;
		}
		try {
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 否则拦截
		return false;
	}

	//拦截后处理  
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {
	}

	//全部完成后处理  
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {
	}
}
