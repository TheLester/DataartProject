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
	src="<c:url value="/resources/js/custom-js/delete-arrangement.js"/>"></script>
</head>
<body>
	<div class="bs-example" id="warn">
  <div class="alert alert-error">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>Note!</strong> Cannot delete event. List of events is empty.
    </div>
</div>
<div class="bs-example1" id="suc" >
    <div class="alert alert-success">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>Success!</strong> Event has been deleted successfully.
    </div>
</div>

<div class="panel panel-info">
      <div class="panel-heading">
        <h3 class="panel-title"><h2>Delete Event</h2></h3>
      </div>
      <div class="panel-body"> 
	  
	
	<form:form id="reviewForm" method="post">
		<select name="selector" onclick="var selector_value=document.forms["reviewForm"].selector.value;">
			<c:forEach items="${arrangements}" var="arrangements">
				<option value="${arrangements.id}">${arrangements.name}</option>
			</c:forEach>
		</select>				
		<br/>
		<input type="hidden" id="NotNull" name="NotNull" value="true">
		<button type="submit" id="submitDemo" onclick="checkNotNull();"  class="btn btn-primary btn-lg">Delete</button>
	</form:form>
	</div>
	</div>
</body>
</html>