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
<script>
function setFields() {
	var selector_value=document.forms["reviewForm"].selector.value;
	console.log("Selector: "+selector_value);
	if(selector_value!="") {
		var res = selector_value.split("/");	
		console.log(res);
		document.forms["reviewForm"].arrangement_id.value=res[0];
		document.forms["reviewForm"].name.value=res[1];	
		var datetime=res[2].split(" ");
		document.forms["reviewForm"].date.value=datetime[0];
		document.forms["reviewForm"].time.value=datetime[1];
	} else // hide input fields
	{
		console.log("Inputs +++++++++++++++++++++++++");
		setInputs("no");
	}
}

function setInputs(status) {	
		document.getElementById("name").style.display=status;
		document.getElementById("date").style.display=status;
		document.getElementById("time").style.display=status;
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

function sleep(milliseconds) { 
    var start = new Date().getTime(); 
    for (var i = 0; i < 1e7; i++) { 
            if ((new Date().getTime() - start) > milliseconds){ break; } 
    } 
}

</script>
</head>
<body onload="setFields();">
	<h2>Edit Event</h2>
	<form:form id="reviewForm" method="post">		
		<table>
			<tr>
				<td>Event to edit:</td>
				<td><select name="selector" onclick="setFields()">
					<c:forEach items="${arrangements}" var="arrangements">				
						<option value="${arrangements.id}/${arrangements.name}/${arrangements.date}">${arrangements.name}</option>										
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" id="name" name="name" /> </td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><input type="date" id="date" name="date"/></td>
			</tr>
			<td>Time:</td>
			<td><input type="time" id="time" name="time"/></td>
		</table>
		<br />
		<input type="hidden" id="NotNull" name="NotNull" value="true">
		<input type="hidden" id="arrangement_id" name="arrangement_id" value="true">
		<input type="submit"  onclick="checkForNull();" value="Save" />
	</form:form>
</body>
</html>



