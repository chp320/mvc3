<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="model.vo.MemberVO, model.service.EncDecService" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>JSP 학습</title>
</head>
<body>
	<h2>회원 정보(EL)</h2>
    <hr>
    <ul>
        <li>회원 이름: ${ membervo.name }</li>
        <li>회원 계정: ${ membervo.id }</li>
        <li>회원 암호: ${ requestScope.membervo.passwd }
                    (${ EncDecService.decrypt(requestScope.membervo.passwd)})</li>
        <li>회원 전화번호: ${ requestScope.membervo.phoneNum }</li>
    </ul>
    <hr>
    <a href='<%= request.getHeader("referer")%>'>돌아가기...</a>
</body>
</html>