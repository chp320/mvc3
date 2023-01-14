<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="model.vo.CountVO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>application scope</title>
</head>
<body>
	<h2>application scope 객체 공유</h2>
	<hr>
	<%-- ServletContext 객체에서 applicationobj 명으로 보관된 객체를 추출 --%>
	<%
		CountVO vo = (CountVO) application.getAttribute("applicationobj");
	%>
	<h3>추출된 카운트 값: <%= vo.getNumber() %></h3>
	<hr>
	<jsp:useBean id="applicationobj" class="model.vo.CountVO" scope="application" />
	<h3>추출된 카운트 값(액션 태그): <jsp:getProperty name="applicationobj" property="number"/></h3>
	<hr>
	<h3>추출된 카운트 값(EL): ${ applicationobj.number }</h3>
</body>
</html>