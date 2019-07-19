package com.tedu.jt.web.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.jt.utils.JDBCUtils;

public class ProdUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// 0.��������(�������˹�������������,���ﲻҪ�ظ�����!)
		// >>�����������
		request.setCharacterEncoding("utf-8");
		// >>��Ӧ��������
		response.setContentType("text/html;charset=utf-8");
		
		// 1.��ȡ��Ʒ��Ϣ
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		double price = Double
				.parseDouble(request.getParameter("price"));
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		String description = request.getParameter("description");
		
		// 2.������Ʒid�޸���Ʒ��Ϣ
		updProdById(id, name, category, price, pnum, description);

		// 3.��ʾ�û���Ʒ��Ϣ�޸ĳɹ�.
		response.getWriter()
				.write("<h1 style='color:red;text-align:center'>");
		response.getWriter().write("��Ʒ��Ϣ�޸ĳɹ�, 3�뽫����ת����̨������ҳ..");
		response.getWriter().write("</h1>");
		// 4.��ʱˢ�µ�ProdListServlet, ��ѯ��Ʒ�б�
		response.setHeader("Refresh", "3;url="
				+ request.getContextPath() + "/ProdListServlet");
	}
	
	/**
	 * �޸���Ʒ��Ϣ
	 * @param id
	 * @param name
	 * @param category
	 * @param price
	 * @param pnum
	 * @param description
	 */
	private void updProdById(int id, String name, String category,
			double price, int pnum, String description) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.��ȡ����
			conn = JDBCUtils.getConn();
			// 2.����sql���
			String sql = "update product set name=?,category=?,price=?,"
					+ "pnum=?, description=? where id=?";
			// 3.��ȡ������
			ps = conn.prepareStatement(sql);
			// 4.����sql����
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, description);
			ps.setInt(6, id);
			// 5.ִ��sql���
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("��Ʒ��Ϣ�޸�ʧ��!");
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}