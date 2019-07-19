<%@ page language="java"
	isErrorPage="true"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title></title>
</head>
<body>
	<h1 style="color:red">
		<%= exception.getMessage() %>
	</h1>
	<img src="${pageContext.request.contextPath}/backend/500.jpg"/>
</body>
</html>


