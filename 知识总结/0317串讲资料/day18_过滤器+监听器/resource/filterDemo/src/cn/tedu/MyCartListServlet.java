package cn.tedu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ѯ��ǰ��½�û����ﳵ�е�������Ʒ����ʾ��ҳ����
 */
public class MyCartListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* ��ѯ��ǰ��½�û����ﳵ�е�������Ʒ����ʾ��ҳ����(ģ��) */
		
		/* 
		 * (1)����û�û�е�½���ܲ�ѯ���ﳵ��Ʒ������Ҫ
		 *   ��ת�ص�½ҳ����ʾ�û���½
		 * (2)����û��Ѿ���½�����ѯ��ǰ��½�˵����й���
		 *   ����Ʒ����ʾ����ҳ��
		 */
		
		//��ѯ���ݿ⣬��ѯ����ǰ��½�˵����й��ﳵ��Ʒ(ģ��)
		
		List<String> List = new ArrayList<String>();
		List.add("���ﳵ: С���ֻ�		��� 1379��");
		List.add("���ﳵ: ����ϴ�»�		��� 2119��");
		List.add("���ﳵ: ������ƤЬ		��� 399��");
		List.add("���ﳵ: Iphone8 plus	��� 6999��");
		
		request.setAttribute("list", List);
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
