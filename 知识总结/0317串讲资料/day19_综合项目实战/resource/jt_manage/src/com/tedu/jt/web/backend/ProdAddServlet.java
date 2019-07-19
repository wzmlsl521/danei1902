package com.tedu.jt.web.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;

/**
 * 添加商品
 */
public class ProdAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// 0.处理乱码(如果添加了过滤器处理乱码,这里不要重复处理!)
		// >>请求参数乱码
		request.setCharacterEncoding("utf-8");
		// >>响应正文乱码
		response.setContentType("text/html;charset=utf-8");
		// 1.获取商品信息
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		double price = Double
				.parseDouble(request.getParameter("price"));
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String description = request.getParameter("description");

		// 2.将商品信息存入数据库中
		addProd(name, category, price, pnum, description);
		
		// 3.提示用户商品添加成功.
		response.getWriter()
				.write("<h1 style='color:red;text-align:center'>");
		response.getWriter().write("商品添加成功, 3秒将会跳转到后台管理首页..");
		response.getWriter().write("</h1>");
		// 4.定时刷新到ProdListServlet, 查询商品列表
		response.setHeader("Refresh", "3;url="
				+ request.getContextPath() + "/ProdListServlet");
	}

	/**
	 * 将商品信息存入数据库中
	 * 
	 * @param name
	 * @param category
	 * @param price
	 * @param pnum
	 * @param description
	 */
	private void addProd(String name, String category, double price,
			int pnum, String description) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.获取连接
			conn = JDBCUtils.getConn();
			// 2.声明sql语句
			String sql = "insert into product values(null, ?,?,?,?,?)";
			// 3.获取传输器
			ps = conn.prepareStatement(sql);
			// 4.设置sql参数
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, description);
			// 5.执行sql语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品添加失败!");
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
