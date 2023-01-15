<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>JSP 학습</title>
	<style>
		span {
			color: hotpink;
		}
	</style>
</head>
<body>
	<h1>오류가 발생했어요!</h1>
	<hr>
	<h2>오류의 원인 : <span>${ requestScope.msg }</span></h2>
	<a href='<%= request.getHeader("referer")%>'>돌아가기...</a>
</body>
</html>