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
 * ������Ʒid��ѯ��Ʒ��Ϣ
 */
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// 1.��ȡ��Ʒid
		int pid = Integer.parseInt(request.getParameter("pid"));
		// 2.������Ʒid��ѯ��Ʒ��Ϣ
		Product prod = findProdById(pid);
		// 3.����Ʒ��Ϣ����request����
		request.setAttribute("prod", prod);
		// 4.ͨ��ת������Ʒ��Ϣ����prod_update.jsp�����޸�
		request.getRequestDispatcher("/backend/prod_upd.jsp")
				.forward(request, response);

	}
	
	/**
	 * ������Ʒid��ѯ��Ʒ��Ϣ 
	 * @param pid ��Ʒid
	 * @return Product ��Ʒ����
	 */
	private Product findProdById(int pid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.��ȡ����
			conn = JDBCUtils.getConn();
			// 2.����sql���
			String sql = "select * from product  where id=?";
			// 3.��ȡ������
			ps = conn.prepareStatement(sql);
			// 4.����sql����
			ps.setInt(1, pid);
			// 5.ִ��sql���
			rs = ps.executeQuery();
			Product prod = null;
			// 6.���������(��ȡ��һ�м�¼)
			if(rs.next()) {
				// 7.����һ�м�¼��װ��product������
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
			System.out.println("��Ʒ��ѯʧ��!");
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
