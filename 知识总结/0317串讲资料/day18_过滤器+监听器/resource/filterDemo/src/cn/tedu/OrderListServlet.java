package cn.tedu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 查询当前登陆用户的所有订单并显示在页面上 
 */
public class OrderListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 查询当前登陆用户的所有订单并显示在页面上(模拟) */
		/* 
		 * (1)如果用户没有登陆则不能查询"我的订单"，则需要
		 *   跳转回登陆页面提示用户登陆
		 * (2)如果用户已经登陆，则查询当前登陆人的所有订单
		 *   列表并显示在网页中
		 */
		
		//查询数据库，查询出当前登陆人的所有订单信息(模拟)
		
		List<String> list = new ArrayList<String>();
		list.add("订单: vivox7 plus	订单金额 1999￥");
		list.add("订单: 三星s8		订单金额 2459￥");
		list.add("订单: 阿迪王皮鞋	订单金额 399￥");
		list.add("订单: Iphone8 plus	订单金额 6999￥");
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
