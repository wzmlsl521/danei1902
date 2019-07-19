package cn.tedu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 查询当前登陆用户购物车中的所有商品并显示在页面上
 */
public class MyCartListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 查询当前登陆用户购物车中的所有商品并显示在页面上(模拟) */
		
		/* 
		 * (1)如果用户没有登陆则不能查询购物车商品，则需要
		 *   跳转回登陆页面提示用户登陆
		 * (2)如果用户已经登陆，则查询当前登陆人的所有购物
		 *   车商品并显示在网页中
		 */
		
		//查询数据库，查询出当前登陆人的所有购物车商品(模拟)
		
		List<String> List = new ArrayList<String>();
		List.add("购物车: 小米手机		金额 1379￥");
		List.add("购物车: 海尔洗衣机		金额 2119￥");
		List.add("购物车: 阿迪王皮鞋		金额 399￥");
		List.add("购物车: Iphone8 plus	金额 6999￥");
		
		request.setAttribute("list", List);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
