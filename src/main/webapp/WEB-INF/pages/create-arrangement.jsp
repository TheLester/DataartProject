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
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.jalert.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/jalert.css"/>">
<link rel="stylesheet" media="all"
	href="<c:url value="/resources/css/site.css"/>">
<script>
	$(function() {
		document.getElementById("warn").style.display = 'none';
		document.getElementById("suc").style.display = 'none';
		/*	document.getElementById('warn').addEventListener('click',function(e){	
			document.getElementById("warn").style.display = 'none';
		});*/
	});
</script>
<script>
	function checkForNull() {
		document.getElementById("submitDemo").disabled = true;

		var nameSel = document.forms["reviewForm"].name.value;
		var dateSel = document.forms["reviewForm"].date.value;
		var timeSel = document.forms["reviewForm"].time.value;
		var check = document.forms["reviewForm"].NotNull.value;

		if (!nameSel || !dateSel || !timeSel) {
			document.getElementById("warn").style.display = 'block';
			setTimeout(function() {
				document.getElementById("warn").style.display = 'none';
				document.forms["reviewForm"].submit();
			}, 1500);

			document.forms["reviewForm"].NotNull.value = "false";
		}else{
		console.log(check);
		document.getElementById("suc").style.display = 'block';
		setTimeout(function() {
			document.getElementById("suc").style.display = 'none';
			document.forms["reviewForm"].submit();
		}, 1500);

		
		}
	}
</script>
</head>
<body>
	<div class="bs-example" id="warn">
    <div class="alert alert-info">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>Note!</strong> Please fill all fields.
    </div>
</div>
<div class="bs-example1" id="suc" >
    <div class="alert alert-success">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>Success!</strong> Event has been created successfully.
    </div>
</div>

	<h2 id="myHead">Create Event</h2>
	<form:form id="reviewForm" method="post">
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
		<input type="hidden" id="NotNull" name="NotNull" value="true">
		<button type="submit" id="submitDemo" onclick="checkForNull();"  class="btn btn-primary btn-lg">Create</button>
	</form:form>

</body>
</html>