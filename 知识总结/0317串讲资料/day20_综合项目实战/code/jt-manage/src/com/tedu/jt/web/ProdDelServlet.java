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
 * ������Ʒ��IDɾ��ָ��ID����Ʒ
 */
public class ProdDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.������Ӧ��������
		response.setContentType(
				"text/html;charset=utf-8");
		//1.��ȡ��Ҫ��ɾ����Ʒ��ID
		int id = Integer.parseInt(
				request.getParameter("id"));
		//2.������ƷIDɾ����Ʒ
		delProdById(id);
		//3.��ʾ�û���Ʒɾ���ɹ�
		response.getWriter().write("<h1 "
				+ "style='color:red;"
				+ "text-align:center;'>");
		response.getWriter().write("��Ʒɾ���ɹ�!");
		response.getWriter().write("</h1>");
		//4.3��֮�󽫻���ת����Ʒ�б�ҳ��
		response.setHeader("refresh", "3;url="
				+ request.getContextPath()
				+ "/ProdListServlet");
	}
	/**
	 * ������ƷIDɾ����Ʒ��Ϣ
	 * @param id ��Ʒ��ID
	 */
	private void delProdById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//1.��ȡ����(�����ӳ��л�ȡ)
			conn = JDBCUtils.getConn();
			//2.��ȡ������
			String sql = "delete from "
					+ "product where id=?";
			ps = conn.prepareStatement(sql);
			//3.����sql����
			ps.setInt(1, id);
			//4.ִ��sql���
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��Ʒɾ��ʧ��!");
			throw new RuntimeException("��Ʒɾ��ʧ��!");
		}finally{
			//�ͷ���Դ
			JDBCUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
