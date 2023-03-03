<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>garage Spring MVC</title>
<%@include file="head/head.jsp"%>
</head>
<body>
    <div id="page">
        <jsp:include page="header/header.jsp"></jsp:include>
        <jsp:include page="nav/nav.jsp"></jsp:include>
        <div id="content">
            <div id="left">left gauche</div>
            <div id="center">
                <h1>ERREUR garage Spring MVC</h1>
            </div>
            <div id="right">right</div>
        </div>
        <jsp:include page="footer/footer.jsp"></jsp:include>
    </div>
</body>
</html>