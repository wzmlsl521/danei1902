package cn.tedu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �����û���½����
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.��������
		request.setCharacterEncoding("utf-8");//�����������
		response.setContentType("text/html;charset=utf-8");//��Ӧ��������
		//2.��ȡ�û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//3.��ѯ���ݿ�, ����û��������Ƿ���ȷ(ģ��)
		if("�ŷ�".equals(username) && "123".equals(password)){
			//���е�½
			request.getSession().setAttribute("user", username);
			response.getWriter().write("<h1 style='color:red;text-align:center;'>��ϲ����½�ɹ�, 2��֮�󽫻���ת����ҳ...</h1>");
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/index.jsp");
		}else{//�û������벻��ȷ
			response.getWriter().write("<h1 style='color:red;text-align:center;'>�����û��������벻��ȷ...</h1>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
