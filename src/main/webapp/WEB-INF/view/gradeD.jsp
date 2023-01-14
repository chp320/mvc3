<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>MVC 학습</title>
</head>
<body>
	<h2>${ param.name }님은 D 등급입니다. 꾸준히 노력하세요.</h2>
	<a href='<%= request.getHeader("referer")%>'>돌아가기...</a>
</body>
</html>