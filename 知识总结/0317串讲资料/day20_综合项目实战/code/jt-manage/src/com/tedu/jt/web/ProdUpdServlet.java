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
 * ������Ʒ��ID�޸�ָ��ID����Ʒ��Ϣ
 */
public class ProdUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.��������
		//>>�����������(POST)
		request.setCharacterEncoding("utf-8");
		//>>��Ӧ��������
		response.setContentType(
				"text/html;charset=utf-8");
		//1.��ȡ�޸ĺ����Ʒ��Ϣ
		int id = Integer.parseInt(
				request.getParameter("id"));
		String name = request.getParameter("name");
		String category = request
				.getParameter("category");
		double price = Double.parseDouble(
				request.getParameter("price"));
		int pnum = Integer.parseInt(
				request.getParameter("pnum"));
		String desc = request
				.getParameter("description");
		//2.�޸�ָ��ID����Ʒ��Ϣ
		updateProdById(id, name, category, 
				price, pnum, desc);
		//3.��ʾ�û���Ʒ�޸ĳɹ�
		response.getWriter().write("<h1 "
				+ "style='color:red;"
				+ "text-align:center'>");
		response.getWriter().write("��Ʒ�޸ĳɹ�!");
		response.getWriter().write("</h1>");
		//4.3��֮����ת����Ʒ�б�ҳ��
		response.setHeader("refresh", "3;url="
				+request.getContextPath()
				+"/ProdListServlet");
	}
	/**
	 * ����ID�޸�ָ��ID����Ʒ��Ϣ
	 * @param id	��ƷID
	 * @param name	��Ʒ����
	 * @param category	��Ʒ����
	 * @param price	��Ʒ����
	 * @param pnum	��Ʒ�������
	 * @param desc	��Ʒ����
	 */
	private void updateProdById(int id, 
			String name, String category, 
			double price, int pnum, 
			String desc) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.��ȡ����
			conn = JDBCUtils.getConn();
			//2.��ȡ������
			String sql = "update product set "
					+ "name=?,category=?,"
					+ "price=?,pnum=?,"
					+ "description=? where id=?";
			ps = conn.prepareStatement(sql);
			//3.���ò���
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, desc);
			ps.setInt(6, id);
			//4.ִ��sql���,����޸�
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��Ʒ�޸�ʧ��!");
			throw new RuntimeException("��Ʒ�޸�ʧ��!");
		} finally{
			JDBCUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
