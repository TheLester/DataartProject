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
	<h2>Create Arrangement</h2>
	<form:form method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /> </td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><input type="date" name="date"/></td>
			</tr>
			<td>Time:</td>
			<td><input type="time" name="time"/></td>
		</table>
		<br />
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>