<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Spring Security Example</title>
</head>
<body>
	<c:if test="${param.error != null}">
		<div>Invalid username and password.${param.error.message}</div>
	</c:if>
	<c:if test="${param.logout != null}">
	<div >You have been logged out.</div>
	</c:if>
	<h1>login dans view</h1>
	<form action="login" method="post">
		<div>
			<label>Id : <input type="text" name="username" />
			</label>
		</div>
		<div>
			<label>Password: <input type="password" name="password" />
			</label>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div>
			<input type="submit" value="Ok" />
		</div>
	</form>
</body>
</html>