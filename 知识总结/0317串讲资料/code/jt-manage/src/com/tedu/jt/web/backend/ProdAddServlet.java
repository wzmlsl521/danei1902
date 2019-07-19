package com.tedu.jt.web.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;
/** 处理商品添加请求 */
public class ProdAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.乱码处理
		//>>请求参数乱码(POST)
		request.setCharacterEncoding("utf-8");
		//>>响应中文乱码
		response.setContentType(
				"text/html;charset=utf-8");
		//1.获取将要添加的商品信息
		String name = 
				request.getParameter("name");
		String category = 
				request.getParameter("category");
		double price = Double.parseDouble(
				request.getParameter("price"));
		int pnum = Integer.parseInt(
				request.getParameter("pnum"));
		String desc =
				request.getParameter("description");
		
		//2.调用addProd方法将商品信息添加到数据库
		addProd(name,category,price,pnum,desc);
		
		//3.提示用户商品添加成功
		PrintWriter out = response.getWriter();
		out.write("<h1 style='color:blue'>");
		out.write("商品添加成功, 3秒之后将会跳"
				+ "转到商品列表页面...");
		out.write("</h1>");
		//4.定时刷新: 3秒后跳转到商品列表页面
		response.setHeader("Refresh", 
			"3;url="+request.getContextPath()
			+"/prod_list.jsp");
	}
	/**
	 * 将商品信息添加到数据库中保存
	 * @param name
	 * @param category
	 * @param price
	 * @param pnum
	 * @param desc
	 */
	private void addProd(String name, 
			String category, double price, 
			int pnum, String desc) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.从c3p0连接池中获取一个连接对象
			conn = JDBCUtils.getConn();
			//2.获取传输器
			String sql = "insert into product"
				+ " values(null,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			//3.设置SQL参数
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, desc);
			//4.执行SQL语句
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品添加失败!!");
		} finally {
			//释放资源
			JDBCUtils.close(conn, ps, rs);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




