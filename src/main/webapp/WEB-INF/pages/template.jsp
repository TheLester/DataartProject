<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8" />
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<meta name="keywords" content="" />
<meta name="description" content="" />
<title>${title}</title>
</head>
<body>
	<div class="fix">
		<jsp:include page="header.jsp" />
		<jsp:include page="${partial}" />
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>