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
 * ������Ʒ��ID��ѯָ��ID����Ʒ��Ϣ
 */
public class ProdInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.��ȡ��Ʒ��ID
		int id = Integer.parseInt(
				request.getParameter("id"));
		//2.����ID��ѯ��Ʒ
		Product prod = findProdById(id);
		//3.����Ʒ������ӵ�request����
		request.setAttribute("prod", prod);
		//4.ͨ��ת������Ʒ��Ϣ����prod_upd.jspչʾ
		request.getRequestDispatcher(
				"/backend/prod_upd.jsp")
				.forward(request, response);
	}
	/**
	 * ������Ʒ��ID��ѯָ��ID����Ʒ��Ϣ
	 * @param id	��ƷID
	 * @return	Product
	 */
	private Product findProdById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.��ȡ����(�����ݿ��л�ȡ)
			conn = JDBCUtils.getConn();
			//2.��ȡ������
			String sql = "select * from "
					+ "product where id=?";
			ps = conn.prepareStatement(sql);
			//3.���ò���
			ps.setInt(1, id);
			//4.ִ��sql���,����ִ�н��
			rs = ps.executeQuery();
			//5.������
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
			System.out.println("��Ʒ��ѯʧ��!");
			throw new RuntimeException("��Ʒ��ѯʧ��!");
		} finally{
			JDBCUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
