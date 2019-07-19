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
 * 根据商品的ID查询指定ID的商品信息
 */
public class ProdInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取商品的ID
		int id = Integer.parseInt(
				request.getParameter("id"));
		//2.根据ID查询商品
		Product prod = findProdById(id);
		//3.将商品对象添加到request域中
		request.setAttribute("prod", prod);
		//4.通过转发将商品信息带到prod_upd.jsp展示
		request.getRequestDispatcher(
				"/backend/prod_upd.jsp")
				.forward(request, response);
	}
	/**
	 * 根据商品的ID查询指定ID的商品信息
	 * @param id	商品ID
	 * @return	Product
	 */
	private Product findProdById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.获取连接(从数据库中获取)
			conn = JDBCUtils.getConn();
			//2.获取传输器
			String sql = "select * from "
					+ "product where id=?";
			ps = conn.prepareStatement(sql);
			//3.设置参数
			ps.setInt(1, id);
			//4.执行sql语句,返回执行结果
			rs = ps.executeQuery();
			//5.处理结果
			Product prod = null;
			if(rs.next()){
				prod = new Product(
						id, 
						rs.getString("name"), 
						rs.getString("category"), 
						rs.getDouble("price"), 
						rs.getInt("pnum"), 
						rs.getString("description"));
			}
			return prod;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品查询失败!");
			throw new RuntimeException("商品查询失败!");
		} finally{
			JDBCUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
