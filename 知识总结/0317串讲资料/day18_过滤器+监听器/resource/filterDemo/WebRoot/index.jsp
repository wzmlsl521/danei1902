<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>filter Demo</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	<body>
		<!-- 如果用户没有登陆, 就提示用户登陆或注册 -->
		<c:if test="${ empty sessionScope.user }">
			您还没有登陆？请
			<a href="${ pageContext.request.contextPath }/login.jsp">登录</a>
		</c:if>
		<!-- 如果用户已经登陆了, 就提示欢迎xx回来 -->
		<c:if test="${ !(empty sessionScope.user) }">
			欢迎 ${ user } 回来,&nbsp;
			<a href="${ pageContext.request.contextPath }/servlet/LogoutServlet">退出</a>
		</c:if>
		
		<span style="margin-left:50%"></span>
		<a href="${ pageContext.request.contextPath }/servlet/MyCartListServlet">我的购物车</a>&nbsp;|
		<a href="${ pageContext.request.contextPath }/servlet/OrderListServlet">我的订单</a>
	</body>
</html>
