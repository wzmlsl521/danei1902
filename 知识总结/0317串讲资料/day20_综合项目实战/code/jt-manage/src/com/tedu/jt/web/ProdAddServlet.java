package com.tedu.jt.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.jt.utils.JDBCUtils;

/**
 * 处理商品添加请求
 */
public class ProdAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.处理乱码
		//>>请求参数乱码
		request.setCharacterEncoding("utf-8");
		//>>响应正文乱码
		response.setContentType("text/html;charset=utf-8");
		//1.获取请求参数(要添加的商品信息)
		String name = request
				.getParameter("name");
		String category = request
				.getParameter("category");
		double price = Double.parseDouble(
				request.getParameter("price"));
		int pnum = Integer.parseInt(
				request.getParameter("pnum"));
		String desc = request
				.getParameter("description");
		
		//2.添加商品信息到数据库中
		addProd(name, category, price, pnum, desc);
		
		//3.提示用户商品添加成功
		response.getWriter().write("<h1 style='color:red;text-align:center'>");
		response.getWriter().write("恭喜您, 商品添加成功!");
		response.getWriter().write("</h1>");
		
		//4.3秒之后跳转到商品列表页面
		/*response.setHeader("refresh", "3;url="
					+request.getContextPath()
					+"/backend/prod_list.jsp");*/
		response.setHeader("refresh", "3;url="
				+request.getContextPath()
				+"/ProdListServlet");
	}
	/**
	 * 将商品信息添加到数据库中
	 * @param name 商品名称
	 * @param category	商品分类
	 * @param price 商品单价
	 * @param pnum	商品库存数量
	 * @param desc	商品的描述
	 */
	private void addProd(String name, String category, double price, int pnum, String desc) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//0.创建连接池对象
		//ComboPooledDataSource pool = 
		//		new ComboPooledDataSource();
		try {
			/* 连接池对象在创建时会去找一个配置文件, 
			 * 在src目录(或相似的目录下)找名称为
			 * c3p0-config.xml的文件, 找到之后读取
			 * 文件中配置的连接数据库的信息, 连接数据库
			 * 自动获取一批连接存放在连接池中, 供外界
			 * 获取, 获取方式为:pool.getConnection()
			 */
			//1.获取连接(从连接池中获取)
			conn = JDBCUtils.getConn();
			//2.获取传输器
			String sql = "insert into product "
					+ "values(null,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			//3.设置参数
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, desc);
			
			//4.执行sql语句,返回执行结果
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("商品添加失败!");
			throw new RuntimeException("商品添加失败!");
		} finally{
			//释放资源
			JDBCUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
