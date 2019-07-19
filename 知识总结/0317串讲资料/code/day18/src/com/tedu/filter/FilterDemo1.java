package com.tedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter {
	/* 在Filter实例创建之后立即执行,进行初始
	 * 化的操作 */
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("FilterDemo1.init()");
	}
	/** 当过滤器拦截到请求后, 将会调用doFilter
	 * 方法, 对请求进行相关处理 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterDemo1.doFilter()");
		//模拟判断当前用户是否登录
		String username = 
				req.getParameter("username");
		if("张飞".equals(username)) {
			System.out.println("用户已登录,放行...");
			//放行过滤器(才能访问到后面的资源)
			chain.doFilter(req, res);
		}else {
			//模拟跳转到登录页面, 提示用户登录
			res.setContentType(
					"text/html;charset=utf-8");
			res.getWriter().write(
					"您还没有登录, 请先登录...");
		}
	}
	
	/* 在Filter实例销毁之前执行destroy方法, 
	 * 进行善后的处理 */
	public void destroy() {
		System.out.println("FilterDemo1.destroy()");
	}

	
	
	
	
}
