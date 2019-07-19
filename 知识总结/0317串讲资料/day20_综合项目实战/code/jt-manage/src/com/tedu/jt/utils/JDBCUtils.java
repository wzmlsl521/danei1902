package com.tedu.jt.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static ComboPooledDataSource pool 
			= new ComboPooledDataSource();
	
	/**
	 * 从连接池中获取一个连接
	 * @return Connection连接对象
	 * @throws SQLException
	 */
	public static Connection getConn() 
			throws SQLException{
		return pool.getConnection();
	}
	
	/**
	 * 释放资源
	 * @param conn 连接
	 * @param ps 传输器
	 * @param rs 结果集
	 */
	public static void close(
			Connection conn, 
			Statement ps, 
			ResultSet rs){
		//释放资源
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				rs = null;
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				ps = null;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				conn = null;
			}
		}
	}
}
