<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page trimDirectiveWhitespaces="true"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="English" />
<link rel="stylesheet" media="all"
	href="<c:url value="/resources/css/site.css"/>">
</head>
<body>
	<h2>Delete Event</h2>
	<form:form method="post">
		<select name="selector">
			<c:forEach items="${arrangements}" var="arrangements">				
				<option value="${arrangements.id}">${arrangements.name}</option>
			</c:forEach>
		</select>		
		<br />
		<input type="submit" value="Delete" />
	</form:form>
</body>
</html>