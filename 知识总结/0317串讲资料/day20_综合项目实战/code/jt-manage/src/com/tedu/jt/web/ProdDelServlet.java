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
 * 根据商品的ID删除指定ID的商品
 */
public class ProdDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.处理响应正文乱码
		response.setContentType(
				"text/html;charset=utf-8");
		//1.获取将要被删除商品的ID
		int id = Integer.parseInt(
				request.getParameter("id"));
		//2.根据商品ID删除商品
		delProdById(id);
		//3.提示用户商品删除成功
		response.getWriter().write("<h1 "
				+ "style='color:red;"
				+ "text-align:center;'>");
		response.getWriter().write("商品删除成功!");
		response.getWriter().write("</h1>");
		//4.3秒之后将会跳转到商品列表页面
		response.setHeader("refresh", "3;url="
				+ request.getContextPath()
				+ "/ProdListServlet");
	}
	/**
	 * 根据商品ID删除商品信息
	 * @param id 商品的ID
	 */
	private void delProdById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.获取连接(从连接池中获取)
			conn = JDBCUtils.getConn();
			//2.获取传输器
			String sql = "delete from "
					+ "product where id=?";
			ps = conn.prepareStatement(sql);
			//3.设置sql参数
			ps.setInt(1, id);
			//4.执行sql语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品删除失败!");
			throw new RuntimeException("商品删除失败!");
		}finally{
			//释放资源
			JDBCUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
