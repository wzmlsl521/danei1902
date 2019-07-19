package com.tedu.jt.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tedu.jt.utils.JDBCUtils;

public class ProdService {
	/**
	 * ��ѯ���е���Ʒ��Ϣ
	 * @return List<Product>
	 */
	public List<Product> findProdList(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//0.����һ�����ӳ�ʵ��
		//ComboPooledDataSource pool = 
		//		new ComboPooledDataSource();
		try {
			//1.��ȡ����(�����ӳ��л�ȡ)
			conn = JDBCUtils.getConn();
			//2.��ȡ������
			String sql = "select * from product";
			ps = conn.prepareStatement(sql);
			//3.ִ��sql���, ����ִ�н��
			rs = ps.executeQuery();
			//4.��������
			//>>�����е���Ʒ��Ϣ��Product�������ʽ����List����
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
			System.out.println("��Ʒ��ѯʧ�ܣ�");
			throw new RuntimeException("��Ʒ��ѯʧ��!");
		} finally{
			//�ͷ���Դ
			JDBCUtils.close(conn, ps, rs);
		}
	}
}
