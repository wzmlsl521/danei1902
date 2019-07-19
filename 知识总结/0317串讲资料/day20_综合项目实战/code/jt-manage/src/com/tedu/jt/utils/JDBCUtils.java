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
	 * �����ӳ��л�ȡһ������
	 * @return Connection���Ӷ���
	 * @throws SQLException
	 */
	public static Connection getConn() 
			throws SQLException{
		return pool.getConnection();
	}
	
	/**
	 * �ͷ���Դ
	 * @param conn ����
	 * @param ps ������
	 * @param rs �����
	 */
	public static void close(
			Connection conn, 
			Statement ps, 
			ResultSet rs){
		//�ͷ���Դ
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
