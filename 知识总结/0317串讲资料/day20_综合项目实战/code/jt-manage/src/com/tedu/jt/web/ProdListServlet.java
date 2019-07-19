package com.tedu.jt.web;
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

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.jt.utils.JDBCUtils;
/**
 * 查询所有的商品信息
 */
public class ProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.查询所有的商品信息
		ProdService service = new ProdService();
		List<Product> list = service.findProdList();
		
		//2.将list集合存入request域中
		request.setAttribute("list", list);
		
		//3.通过转发将所有的商品信息带到jsp中展示
		request.getRequestDispatcher(
				"/backend/prod_list.jsp")
				.forward(request, response);
	}
	/**
	 * 查询所有的商品信息, 作为list集合返回
	 * @return List<Product>
	
	private List<Product> findProdList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//0.创建一个连接池实例
		//ComboPooledDataSource pool = 
		//		new ComboPooledDataSource();
		try {
			//1.获取连接(从连接池中获取)
			conn = JDBCUtils.getConn();
			//2.获取传输器
			String sql = "select * from product";
			ps = conn.prepareStatement(sql);
			//3.执行sql语句, 返回执行结果
			rs = ps.executeQuery();
			//4.处理结果集
			//>>将所有的商品信息以Product对象的形式存入List集合
			List<Product> list = new ArrayList<Product>();
			Product prod = null;
			while(rs.next()){
				prod = new Product(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("category"), 
						rs.getDouble("price"), 
						rs.getInt("pnum"), 
						rs.getString("description"));
				list.add(prod);
			}
			System.out.println("list="+list);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品查询失败！");
			throw new RuntimeException("商品查询失败!");
		} finally{
			//释放资源
			JDBCUtils.close(conn, ps, rs);
		}
	} */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
