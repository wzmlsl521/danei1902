package cn.tedu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 处理用户登陆请求
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.处理乱码
		request.setCharacterEncoding("utf-8");//请求参数乱码
		response.setContentType("text/html;charset=utf-8");//响应正文乱码
		//2.获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//3.查询数据库, 检查用户名密码是否正确(模拟)
		if("张飞".equals(username) && "123".equals(password)){
			//进行登陆
			request.getSession().setAttribute("user", username);
			response.getWriter().write("<h1 style='color:red;text-align:center;'>恭喜您登陆成功, 2秒之后将会跳转到首页...</h1>");
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/index.jsp");
		}else{//用户名密码不正确
			response.getWriter().write("<h1 style='color:red;text-align:center;'>您的用户名或密码不正确...</h1>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
