package com.tedu.jt.web.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;

public class ProdDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// 0.处理乱码(如果添加了过滤器处理乱码,这里不要重复处理!)
		// >>响应正文乱码
		response.setContentType("text/html;charset=utf-8");
		// 1.获取商品id
		int pid = Integer.parseInt(request.getParameter("pid"));
		// 2.根据商品id删除商品信息
		delProdById(pid);
		// 3.提示用户商品删除成功.
		response.getWriter()
				.write("<h1 style='color:red;text-align:center'>");
		response.getWriter().write("商品删除成功, 3秒将会跳转到后台管理首页..");
		response.getWriter().write("</h1>");
		// 4.定时刷新到ProdListServlet, 查询商品列表
		response.setHeader("Refresh", "3;url="
				+ request.getContextPath() + "/ProdListServlet");
	}
	/**
	 * 根据商品id删除商品信息
	 * @param pid
	 */
	private void delProdById(int pid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.获取连接
			conn = JDBCUtils.getConn();
			// 2.声明sql语句
			String sql = "delete from product where id=?";
			// 3.获取传输器
			ps = conn.prepareStatement(sql);
			// 4.设置sql参数
			ps.setInt(1, pid);;
			// 5.执行sql语句
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品删除失败!");
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
