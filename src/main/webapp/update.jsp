<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
		<input type="hidden" name="id" value="${u.id}">
		姓名:<input name="username" value="${u.username}" >
		密码:<input name="password" value="${u.password}">
		<input type="submit" value="提交"><br>
	</form>

</body>
</html>