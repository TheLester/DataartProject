<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Черноморец</title>
<meta charset="utf-8" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<meta name="keywords" content="" />
<meta name="description" content="" />
<script src="/resources/js/jquery-1.11.1.js"></script>
<script src="/resources/js/jquery-ui.js"></script>
<script src="/resources/js/datepickr.min.js"></script>
</head>
<body>
	<div class="fix">
		<div class="header">
			<div class="logo">
				<img
					src="<c:url value="/resources/images/1331728310_21907583.gif" />">
			</div>
		</div>
		<div class="afterHeaderSpace"></div>
		<div class="navigation">
			<ul>
				<li><a href="arrangements.html">Матчи</a></li>
				<li><a href="">Билетная схема</a></li>
				<li><a href="">Билеты</a></li>
				<li><a href="">Расписание матчей</a></li>
				<li><a href="">О системе</a></li>
				<li><a href="">Layout</a></li>
				<li><a href="">Contact</a></li>
			</ul>
		</div>
		<h3>Another date picker:</h3>
		<form action="demo_form.asp">
			Birthday: <input type="date" name="bday"> <input
				type="submit">
		</form>
</body>
</html>