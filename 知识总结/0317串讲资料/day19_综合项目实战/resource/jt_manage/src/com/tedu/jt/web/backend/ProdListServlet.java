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

public class ProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// 1.查询所有商品信息, 返回所有商品组成的List集合
		List<Product> list = findProdList();
		// 2.将所有商品集合存入request域中
		request.setAttribute("list", list);
		// 3.通过请求转发将商品信息带到prod_list.jsp中展示
		request.getRequestDispatcher("/backend/prod_list.jsp")
				.forward(request, response);
	}

	/**
	 * 查询所有商品信息
	 * 
	 * @return List集合
	 */
	private List<Product> findProdList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.获取连接
			conn = JDBCUtils.getConn();
			// 2.声明sql语句
			String sql = "select * from product";
			// 3.获取传输器
			ps = conn.prepareStatement(sql);
			// 4.执行sql语句
			rs = ps.executeQuery();
			// 5.创建List集合用于封装所有的商品信息
			List<Product> list = new ArrayList<Product>();
			Product prod = null;
			// 6.遍历结果集
			while (rs.next()) {
				// 7.将每一行记录封装到product对象中
				prod = new Product();
				prod.setId(rs.getInt("id"));
				prod.setName(rs.getString("name"));
				prod.setCategory(rs.getString("category"));
				prod.setPrice(rs.getDouble("price"));
				prod.setPnum(rs.getInt("pnum"));
				prod.setDescription(rs.getString("description"));
				// 8.将product对象添加到list集合中
				list.add(prod);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品查询失败!");
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return null;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
