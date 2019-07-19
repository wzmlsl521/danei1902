package cn.tedu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ѯ��ǰ��½�û������ж�������ʾ��ҳ���� 
 */
public class OrderListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* ��ѯ��ǰ��½�û������ж�������ʾ��ҳ����(ģ��) */
		/* 
		 * (1)����û�û�е�½���ܲ�ѯ"�ҵĶ���"������Ҫ
		 *   ��ת�ص�½ҳ����ʾ�û���½
		 * (2)����û��Ѿ���½�����ѯ��ǰ��½�˵����ж���
		 *   �б���ʾ����ҳ��
		 */
		
		//��ѯ���ݿ⣬��ѯ����ǰ��½�˵����ж�����Ϣ(ģ��)
		
		List<String> list = new ArrayList<String>();
		list.add("����: vivox7 plus	������� 1999��");
		list.add("����: ����s8		������� 2459��");
		list.add("����: ������ƤЬ	������� 399��");
		list.add("����: Iphone8 plus	������� 6999��");
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
