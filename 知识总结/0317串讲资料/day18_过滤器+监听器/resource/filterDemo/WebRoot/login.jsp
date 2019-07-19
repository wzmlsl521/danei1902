<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>filter Demo</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	<body>
		<form action="${ pageContext.request.contextPath }/servlet/LoginServlet" method="POST">
			用户名：<input type="text" name="username" value="张飞"/><br/><br/>
			密码：<input type="text" name="password" value="123"/><br/><br/>
			<input type="submit" value="登陆"/><br/><br/>
		</form>
	</body>
</html>
