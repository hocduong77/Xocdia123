<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<html>
<head>
<link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet">
<title><spring:message code="label.pages.home.title"></spring:message></title>
</head>
<body>

	<div class="container">
	
		<div class="span12">
			<sec:authorize access="hasRole('ROLE_USER')">
				user
			</sec:authorize>

			<sec:authorize access="hasRole('ROLE_ADMIN')">
				admin
				<br />
			</sec:authorize>
			 ${param.user}
			<a href="<c:url value="/j_spring_security_logout" />">logout</a> <a
				href="<c:url value="/home.html" />">login</a> <a
				href="<c:url value="/admin.html" />">admin</a>
		</div>
	</div>
</body>
</html>