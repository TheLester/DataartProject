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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.12/jquery-ui.js"
	type="text/javascript"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.jalert.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/jalert.css"/>">
<script>	
function sleep(milliseconds) { 
        var start = new Date().getTime(); 
        for (var i = 0; i < 1e7; i++) { 
                if ((new Date().getTime() - start) > milliseconds){ break; } 
        } 
}
		function checkForNull() {
			var nameSel = document.forms["reviewForm"].name.value;
			var dateSel = document.forms["reviewForm"].date.value;
			var timeSel = document.forms["reviewForm"].time.value;
			var check = document.forms["reviewForm"].NotNull.value;

			if (!nameSel || !dateSel || !timeSel) {
						sleep(100);
				$(document).jAlert('This is a jAlert Info Box',"info",'infoboxid');	
sleep(300); 					
				document.forms["reviewForm"].NotNull.value = "false";
			}
			console.log(check);
		}	

</script>
</head>
<body>
	<h2>Create Event</h2>
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
		<input type="submit" id="submitDemo" onclick="checkForNull()"
			value="Create" />
	</form:form>

</body>
</html>