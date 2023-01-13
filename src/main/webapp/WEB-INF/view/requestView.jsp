<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="model.vo.CountVO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>request scope</title>
</head>
<body>
<%--	<h2>requestView.jsp</h2>--%>
    <h2>request scope 공유</h2>
    <hr>
    <%
        CountVO vo = (CountVO) request.getAttribute("requestobj");
    %>
    <h3>추출된 카운트 값(스크립트) : <%= vo.getNumber() %></h3>
    <hr>
    <jsp:useBean id="requestobj" class="model.vo.CountVO" scope="request" />
    <h3>추출된 카운트 값(액션 태그) : <jsp:getProperty name="requestobj" property="number"/></h3>
    <hr>
    <h3>추출된 카운트 값(EL) : ${ requestScope.requestobj.number }</h3>
</body>
</html>