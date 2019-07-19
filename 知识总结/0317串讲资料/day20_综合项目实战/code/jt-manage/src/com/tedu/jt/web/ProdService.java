package com.tedu.jt.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tedu.jt.utils.JDBCUtils;

public class ProdService {
	/**
	 * 查询所有的商品信息
	 * @return List<Product>
	 */
	public List<Product> findProdList(){
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
	}
}
