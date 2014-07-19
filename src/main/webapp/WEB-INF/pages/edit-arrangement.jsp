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
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js"/>"></script>
<link rel="stylesheet" media="all"
	href="<c:url value="/resources/css/bootstrap-combined.min.css"/>">
<link rel="stylesheet" media="all"
	href="<c:url value="/resources/css/site.css"/>">
<script type="text/javascript"
	src="<c:url value="/resources/js/custom-js/edit-arrangement.js"/>"></script>
</head>
<body onload="setFields();">
<body>
	<div class="bs-example" id="warn">
		<div class="alert alert-error">
			<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>Note!</strong>
			List of events is empty.
		</div>
	</div>
	<div class="bs-example1" id="suc">
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>Success!</strong>
			Event has been edited successfully.
		</div>
	</div>

	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">
				<h2>Edit Event</h2>
			</h3>
		</div>
		<div class="panel-body">


			<form:form id="reviewForm" method="post">
				<table>
					<tr>
						<td>Event to edit:</td>
						<td><select name="selector" onclick="setFields()">
								<c:forEach items="${arrangements}" var="arrangements">
									<option
										value="${arrangements.id}/${arrangements.name}/${arrangements.date}">${arrangements.name}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>Name:</td>
						<td><input type="text" id="name" name="name" /></td>
					</tr>
					<tr>
						<td>Date:</td>
						<td><input type="date" id="date" name="date" /></td>
					</tr>
					<td>Time:</td>
					<td><input type="time" id="time" name="time" /></td>
				</table>
				<br />
				<input type="hidden" id="arrangement_id" name="arrangement_id"
					value="true">
				<button type="submit" id="submitDemo" onclick="checkForNull();"
					class="btn btn-primary btn-lg">Edit</button>
			</form:form>
		</div>
	</div>
</body>
</html>



