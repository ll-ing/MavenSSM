<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="selectUser" method="post">
		<table border='1' align='center' width='70%' cellpadding='0'
			cellspacing='0'>
			<tr>
				<th>id</th>
				<th>姓名</th>
				<th>密码</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.id}</td>
					<td>${list.username}</td>
					<td>${list.password}</td>
					<td><a href="delete?id=${list.id}">删除</a>
						<a href="updateQueryOne?id=${list.id}">修改</a>
					</td>
				</tr>
			</c:forEach>


		</table>
	</form>

</body>
</html>