<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>MVC 학습</title>
</head>
<body>
    <h2>${ param.name }님은 A 등급입니다. 우수한 성적이네요 (^^)</h2>
    <a href='<%= request.getHeader("referer")%>'>돌아가기...</a>
</body>
</html>