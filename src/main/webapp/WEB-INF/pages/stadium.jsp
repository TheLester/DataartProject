<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Language" content="English"/>
    <link rel="stylesheet" media="all" href="<c:url value="/resources/css/site.css"/>">
		<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.12/jquery-ui.js"
	type="text/javascript"></script>
		<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.js"/>"></script>
	<script language="JavaScript">
function point_it(event){
    pos_x = event.offsetX?(event.offsetX):event.pageX-document.getElementById("pointer_div").offsetLeft;
    pos_y = event.offsetY?(event.offsetY):event.pageY-document.getElementById("pointer_div").offsetTop;   
    document.pointform.form_x.value = pos_x;
    document.pointform.form_y.value = pos_y;
	var myPos = [ pos_x, pos_y ];

    $(document).dialog({
      title: 'Title here',
      draggable:false,
      minHeight:100,
      position: myPos,
      resizable: false  
    });
	
}
</script>
    <title>Scheme of stadium</title>
</head>
<body>
<div class="content">
<h2>Stadium</h2>
	<div class="schema">
	<form name="pointform" method="post">
		<div id="pointer_div" onclick="point_it(event)">		
		</div>
		You pointed on x = <input type="text" name="form_x" size="4" /> - y = <input type="text" name="form_y" size="4" />
	</form> 
	</div>
</div>
</body>
</html>