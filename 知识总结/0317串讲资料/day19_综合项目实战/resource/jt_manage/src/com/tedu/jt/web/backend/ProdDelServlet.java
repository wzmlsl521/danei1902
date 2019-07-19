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

public class ProdDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// 0.��������(�������˹�������������,���ﲻҪ�ظ�����!)
		// >>��Ӧ��������
		response.setContentType("text/html;charset=utf-8");
		// 1.��ȡ��Ʒid
		int pid = Integer.parseInt(request.getParameter("pid"));
		// 2.������Ʒidɾ����Ʒ��Ϣ
		delProdById(pid);
		// 3.��ʾ�û���Ʒɾ���ɹ�.
		response.getWriter()
				.write("<h1 style='color:red;text-align:center'>");
		response.getWriter().write("��Ʒɾ���ɹ�, 3�뽫����ת����̨������ҳ..");
		response.getWriter().write("</h1>");
		// 4.��ʱˢ�µ�ProdListServlet, ��ѯ��Ʒ�б�
		response.setHeader("Refresh", "3;url="
				+ request.getContextPath() + "/ProdListServlet");
	}
	/**
	 * ������Ʒidɾ����Ʒ��Ϣ
	 * @param pid
	 */
	private void delProdById(int pid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.��ȡ����
			conn = JDBCUtils.getConn();
			// 2.����sql���
			String sql = "delete from product where id=?";
			// 3.��ȡ������
			ps = conn.prepareStatement(sql);
			// 4.����sql����
			ps.setInt(1, pid);;
			// 5.ִ��sql���
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��Ʒɾ��ʧ��!");
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
