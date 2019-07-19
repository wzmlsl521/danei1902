package com.tedu.jt.web;

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
 * 根据商品的ID修改指定ID的商品信息
 */
public class ProdUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.处理乱码
		//>>请求参数乱码(POST)
		request.setCharacterEncoding("utf-8");
		//>>响应正文乱码
		response.setContentType(
				"text/html;charset=utf-8");
		//1.获取修改后的商品信息
		int id = Integer.parseInt(
				request.getParameter("id"));
		String name = request.getParameter("name");
		String category = request
				.getParameter("category");
		double price = Double.parseDouble(
				request.getParameter("price"));
		int pnum = Integer.parseInt(
				request.getParameter("pnum"));
		String desc = request
				.getParameter("description");
		//2.修改指定ID的商品信息
		updateProdById(id, name, category, 
				price, pnum, desc);
		//3.提示用户商品修改成功
		response.getWriter().write("<h1 "
				+ "style='color:red;"
				+ "text-align:center'>");
		response.getWriter().write("商品修改成功!");
		response.getWriter().write("</h1>");
		//4.3秒之后跳转到商品列表页面
		response.setHeader("refresh", "3;url="
				+request.getContextPath()
				+"/ProdListServlet");
	}
	/**
	 * 根据ID修改指定ID的商品信息
	 * @param id	商品ID
	 * @param name	商品名称
	 * @param category	商品种类
	 * @param price	商品单价
	 * @param pnum	商品库存数量
	 * @param desc	商品描述
	 */
	private void updateProdById(int id, 
			String name, String category, 
			double price, int pnum, 
			String desc) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.获取连接
			conn = JDBCUtils.getConn();
			//2.获取传输器
			String sql = "update product set "
					+ "name=?,category=?,"
					+ "price=?,pnum=?,"
					+ "description=? where id=?";
			ps = conn.prepareStatement(sql);
			//3.设置参数
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, desc);
			ps.setInt(6, id);
			//4.执行sql语句,完成修改
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品修改失败!");
			throw new RuntimeException("商品修改失败!");
		} finally{
			JDBCUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
