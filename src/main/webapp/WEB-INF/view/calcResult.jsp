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
	<h1>연산 결과</h1>
	<hr>
	<h2>결과 : <span>${ requestScope.result }</span></h2>
	<a href='<%= request.getHeader("referer")%>'>돌아가기...</a>
</body>
</html>