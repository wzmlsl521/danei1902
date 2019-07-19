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

public class ProdUpdServlet extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		double price = Double
				.parseDouble(request.getParameter("price"));
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String description = request.getParameter("description");
		
		// 2.根据商品id修改商品信息
		updProdById(id, name, category, price, pnum, description);

		// 3.提示用户商品信息修改成功.
		response.getWriter()
				.write("<h1 style='color:red;text-align:center'>");
		response.getWriter().write("商品信息修改成功, 3秒将会跳转到后台管理首页..");
		response.getWriter().write("</h1>");
		// 4.定时刷新到ProdListServlet, 查询商品列表
		response.setHeader("Refresh", "3;url="
				+ request.getContextPath() + "/ProdListServlet");
	}
	
	/**
	 * 修改商品信息
	 * @param id
	 * @param name
	 * @param category
	 * @param price
	 * @param pnum
	 * @param description
	 */
	private void updProdById(int id, String name, String category,
			double price, int pnum, String description) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.获取连接
			conn = JDBCUtils.getConn();
			// 2.声明sql语句
			String sql = "update product set name=?,category=?,price=?,"
					+ "pnum=?, description=? where id=?";
			// 3.获取传输器
			ps = conn.prepareStatement(sql);
			// 4.设置sql参数
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, description);
			ps.setInt(6, id);
			// 5.执行sql语句
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("商品信息修改失败!");
			e.printStackTrace();
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