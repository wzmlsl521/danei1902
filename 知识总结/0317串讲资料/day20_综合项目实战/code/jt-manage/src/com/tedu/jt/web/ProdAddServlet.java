package com.tedu.jt.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.jt.utils.JDBCUtils;

/**
 * ������Ʒ�������
 */
public class ProdAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//0.��������
		//>>�����������
		request.setCharacterEncoding("utf-8");
		//>>��Ӧ��������
		response.setContentType("text/html;charset=utf-8");
		//1.��ȡ�������(Ҫ��ӵ���Ʒ��Ϣ)
		String name = request
				.getParameter("name");
		String category = request
				.getParameter("category");
		double price = Double.parseDouble(
				request.getParameter("price"));
		int pnum = Integer.parseInt(
				request.getParameter("pnum"));
		String desc = request
				.getParameter("description");
		
		//2.�����Ʒ��Ϣ�����ݿ���
		addProd(name, category, price, pnum, desc);
		
		//3.��ʾ�û���Ʒ��ӳɹ�
		response.getWriter().write("<h1 style='color:red;text-align:center'>");
		response.getWriter().write("��ϲ��, ��Ʒ��ӳɹ�!");
		response.getWriter().write("</h1>");
		
		//4.3��֮����ת����Ʒ�б�ҳ��
		/*response.setHeader("refresh", "3;url="
					+request.getContextPath()
					+"/backend/prod_list.jsp");*/
		response.setHeader("refresh", "3;url="
				+request.getContextPath()
				+"/ProdListServlet");
	}
	/**
	 * ����Ʒ��Ϣ��ӵ����ݿ���
	 * @param name ��Ʒ����
	 * @param category	��Ʒ����
	 * @param price ��Ʒ����
	 * @param pnum	��Ʒ�������
	 * @param desc	��Ʒ������
	 */
	private void addProd(String name, String category, double price, int pnum, String desc) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//0.�������ӳض���
		//ComboPooledDataSource pool = 
		//		new ComboPooledDataSource();
		try {
			/* ���ӳض����ڴ���ʱ��ȥ��һ�������ļ�, 
			 * ��srcĿ¼(�����Ƶ�Ŀ¼��)������Ϊ
			 * c3p0-config.xml���ļ�, �ҵ�֮���ȡ
			 * �ļ������õ��������ݿ����Ϣ, �������ݿ�
			 * �Զ���ȡһ�����Ӵ�������ӳ���, �����
			 * ��ȡ, ��ȡ��ʽΪ:pool.getConnection()
			 */
			//1.��ȡ����(�����ӳ��л�ȡ)
			conn = JDBCUtils.getConn();
			//2.��ȡ������
			String sql = "insert into product "
					+ "values(null,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			//3.���ò���
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setInt(4, pnum);
			ps.setString(5, desc);
			
			//4.ִ��sql���,����ִ�н��
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��Ʒ���ʧ��!");
			throw new RuntimeException("��Ʒ���ʧ��!");
		} finally{
			//�ͷ���Դ
			JDBCUtils.close(conn, ps, rs);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
