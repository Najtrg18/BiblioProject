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
<!-- <body> -->
<body onload="initPage()">
	<h1>garage Spring MVC toto</h1>
	<!-- 	<form action="/garageSpringBootWeb/bateauDetail" method="post"> -->
	<form action="${pageContext.request.contextPath}/bateauDetail/"
		method="post">
		<p>
			<label>id</label><input name="id" type="text" value="${bateau.id }"
				readonly="readonly" />
		</p>
		<p>
			<!-- 			<label>marque</label><input name="marque" type="text" -->
			<%-- 				value="${bateau.marque }" required="required"/> --%>
			<label>marque</label><select id="marque" name="marque"><option
					value=""></option></select>
		</p>
		<p>
			<label>modele</label><input name="modele" type="text"
				value="${bateau.modele }" required="required" />
		</p>
		<p>
			<label>couleur</label><input onchange="checkCouleur(this)"
				id="couleur" name="couleur" type="text" value="${bateau.couleur }"
				required="required" /> <span></span>
		</p>
		<p>
			<label>immatriculation</label><input
				onchange="checkImmatriculation(this)" id="immatriculation"
				name="immatriculation" type="text"
				value="${bateau.immatriculation }" required="required" /> <span></span>
		</p>
		<p id="erreur">
		<p>
			<input id="btnValidation" type="submit" />
		</p>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>