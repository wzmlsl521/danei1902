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

public class ProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// 1.��ѯ������Ʒ��Ϣ, ����������Ʒ��ɵ�List����
		List<Product> list = findProdList();
		// 2.��������Ʒ���ϴ���request����
		request.setAttribute("list", list);
		// 3.ͨ������ת������Ʒ��Ϣ����prod_list.jsp��չʾ
		request.getRequestDispatcher("/backend/prod_list.jsp")
				.forward(request, response);
	}

	/**
	 * ��ѯ������Ʒ��Ϣ
	 * 
	 * @return List����
	 */
	private List<Product> findProdList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.��ȡ����
			conn = JDBCUtils.getConn();
			// 2.����sql���
			String sql = "select * from product";
			// 3.��ȡ������
			ps = conn.prepareStatement(sql);
			// 4.ִ��sql���
			rs = ps.executeQuery();
			// 5.����List�������ڷ�װ���е���Ʒ��Ϣ
			List<Product> list = new ArrayList<Product>();
			Product prod = null;
			// 6.���������
			while (rs.next()) {
				// 7.��ÿһ�м�¼��װ��product������
				prod = new Product();
				prod.setId(rs.getInt("id"));
				prod.setName(rs.getString("name"));
				prod.setCategory(rs.getString("category"));
				prod.setPrice(rs.getDouble("price"));
				prod.setPnum(rs.getInt("pnum"));
				prod.setDescription(rs.getString("description"));
				// 8.��product������ӵ�list������
				list.add(prod);
			}
			return list;
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
