<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true" %>
 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Language" content="English"/>
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
    <title>Arrangements</title>
</head>
<body>
	<div class="panel panel-info">
      <div class="panel-heading">
        <h3 class="panel-title"><h2>Events</h2></h3>
      </div>
      <div class="panel-body">      

<table id="events">
    <tr>
        <th>Name</th>
        <th>Date</th>
    </tr>
    <c:forEach items="${arrangements}" var="arrangements">
        <tr>
            <td>${arrangements.name}</td>
            <td>${arrangements.date}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value="/create-arrangement"/>">Create Event</a>
<a href="<c:url value="/delete-arrangement"/>">Delete Event</a>
</div>
</div>
</body>
</html>