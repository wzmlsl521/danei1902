package com.tedu.jt.web;
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

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tedu.jt.utils.JDBCUtils;
/**
 * ��ѯ���е���Ʒ��Ϣ
 */
public class ProdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.��ѯ���е���Ʒ��Ϣ
		ProdService service = new ProdService();
		List<Product> list = service.findProdList();
		
		//2.��list���ϴ���request����
		request.setAttribute("list", list);
		
		//3.ͨ��ת�������е���Ʒ��Ϣ����jsp��չʾ
		request.getRequestDispatcher(
				"/backend/prod_list.jsp")
				.forward(request, response);
	}
	/**
	 * ��ѯ���е���Ʒ��Ϣ, ��Ϊlist���Ϸ���
	 * @return List<Product>
	
	private List<Product> findProdList() {
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
	} */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
