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
<script>
	$(function() {
		document.getElementById("warn").style.display = 'none';
		document.getElementById("suc").style.display = 'none';
		document.getElementById('warn').addEventListener('click', function(e) {
			document.getElementById("warn").style.display = 'none';
		});
		document.getElementById('suc').addEventListener('click', function(e) {
			document.getElementById("suc").style.display = 'none';
		});
	});
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
	  document.getElementById("name").readOnly = true;
	  document.getElementById("date").readOnly = true;
	  document.getElementById("time").readOnly = true;			
	}
}

function setInputs(status) {	
		document.getElementById("name").style.display=status;
		document.getElementById("date").style.display=status;
		document.getElementById("time").style.display=status;		
}

function checkForNull() {
	document.getElementById("submitDemo").disabled = true;
	
	var nameSel = document.forms["reviewForm"].name.value;
	var dateSel = document.forms["reviewForm"].date.value;
	var timeSel = document.forms["reviewForm"].time.value;
	var selector_value=document.forms["reviewForm"].selector.value;
	
	if (!nameSel || !dateSel || !timeSel || !selector_value) {				 					
		document.getElementById("warn").style.display = 'block';
			setTimeout(function() {
				document.getElementById("warn").style.display = 'none';
				document.forms["reviewForm"].submit();
			}, 1500);
			
	} else {
	document.getElementById("suc").style.display = 'block';
			setTimeout(function() {
				document.getElementById("suc").style.display = 'none';
				document.forms["reviewForm"].submit();
			}, 1500);
	}
	console.log(check);
}	
</script>
</head>
<body onload="setFields();">
<body>
	<div class="bs-example" id="warn">
 <div class="alert alert-error">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>Note!</strong> List of events is empty.
    </div>
</div>
<div class="bs-example1" id="suc" >
    <div class="alert alert-success">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>Success!</strong> Event has been edited successfully.
    </div>
</div>

<div class="panel panel-info">
      <div class="panel-heading">
        <h3 class="panel-title"><h2>Edit Event</h2></h3>
      </div>
      <div class="panel-body"> 
	  
	
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
				<td><input type="date" id="date" name="date" /></td>
			</tr>
			<td>Time:</td>
			<td><input type="time" id="time" name="time"  /></td>
		</table>
		<br />		
		<input type="hidden" id="arrangement_id" name="arrangement_id" value="true">
		<button type="submit" id="submitDemo" onclick="checkForNull();"  class="btn btn-primary btn-lg">Edit</button>
	</form:form>
	</div>
	</div>
</body>
</html>



