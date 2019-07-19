package com.tedu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * ServletContext对象的生死监听器
 */
public class MyServletContextListener implements ServletContextListener {
	/* 当ServletContext对象创建时调用该方法 */
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println(
			"ServletContext对象轻轻的来了...");
	}
	/* 当ServletContext对象销毁时调用该方法 */
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println(
			"ServletContext对象轻轻的又走了...");
	}

}


