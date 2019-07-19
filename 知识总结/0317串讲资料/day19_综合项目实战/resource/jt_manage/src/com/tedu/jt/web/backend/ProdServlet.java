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

/**
 * 根据商品id查询商品信息
 */
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取商品id
		int pid = Integer.parseInt(request.getParameter("pid"));
		// 2.根据商品id查询商品信息
		Product prod = findProdById(pid);
		// 3.将商品信息存入request域中
		request.setAttribute("prod", prod);
		// 4.通过转发将商品信息带到prod_update.jsp进行修改
		request.getRequestDispatcher("/backend/prod_upd.jsp")
				.forward(request, response);

	}
	
	/**
	 * 根据商品id查询商品信息 
	 * @param pid 商品id
	 * @return Product 商品对象
	 */
	private Product findProdById(int pid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.获取连接
			conn = JDBCUtils.getConn();
			// 2.声明sql语句
			String sql = "select * from product  where id=?";
			// 3.获取传输器
			ps = conn.prepareStatement(sql);
			// 4.设置sql参数
			ps.setInt(1, pid);
			// 5.执行sql语句
			rs = ps.executeQuery();
			Product prod = null;
			// 6.遍历结果集(获取第一行记录)
			if(rs.next()) {
				// 7.将第一行记录封装到product对象中
				prod = new Product();
				prod.setId(rs.getInt("id"));
				prod.setName(rs.getString("name"));
				prod.setCategory(rs.getString("category"));
				prod.setPrice(rs.getDouble("price"));
				prod.setPnum(rs.getInt("pnum"));
				prod.setDescription(rs.getString("description"));
			}
			return prod;
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
