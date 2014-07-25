<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="com.dataart.project.repositories.Sector"%>
<%@ page import="java.util.Set"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="English" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.12/jquery-ui.js"
	type="text/javascript"></script>
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
	src="<c:url value="/resources/js/custom-js/create-arrangement.js"/>"></script>
</head>
<body onload="setFields();">
	<div class="bs-example" id="warn">
		<div class="alert alert-error">
			<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>There
				is an error in the submission!</strong> Please fill all fields.
		</div>
	</div>
	<div class="bs-example1" id="suc">
		<div class="alert alert-success">
			<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>Success!</strong>
			Event has been created successfully.
		</div>
	</div>

	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">
				<h2>Create Event</h2>
			</h3>
		</div>
		<div class="panel-body">

			<form:form modelAttribute="requestSector" id="reviewForm" method="post">
				<table>
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
				<div class="DemoBS2">
					<div class="panel-group" id="accordion">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#accordionOne"> Sectors </a>
								</h4>
							</div>
							<div id="accordionOne" class="panel-collapse collapse">
								<!-- <div id="accordionOne" class="panel-collapse collapse in">-->
								<div class="panel-body">
									<table id="sectors">
										<tr>
											<th>Sector</th>
											<th>Price</th>
										</tr>
										<c:forEach items="${sectors}" var="sector" varStatus="loop">
											<tr>
											<td><form:input path="allSectors[${loop.index}].name" value="${sector.name}" readonly="true"/></td>
											<td><form:input path="allSectors[${loop.index}].price" value="${sector.price}"/></td>
												
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>						
					</div>
				</div>
				</br>
				<input type="hidden" id="NotNull" name="NotNull" value="true">
				<button type="submit" id="submitButton" onclick="checkForNull();"
					class="btn btn-primary btn-lg">Create</button>
			</form:form>
		</div>
	</div>

</body>
</html>