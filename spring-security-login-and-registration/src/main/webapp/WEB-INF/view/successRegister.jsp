<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Xóc đĩa</title>
<meta name="description" content="E learning" />
<meta name="keywords" content="E learning" />
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/default.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/animate.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
</head>

<body>
	<div class="page">
		<%@ include file="header.jsp"%>		

		<div id="content">
			<div class="container">
				<div class="row">
					<div class="content">
						<div class="login-page">

							<div class="register-ses">
								<h2>BẠN ĐÃ ĐĂNG KÝ THÀNH CÔNG</h2>
								<p>Chúng tôi đã gửi một mail kích hoạt vào địa chỉ mail mà
									bạn cung cấp. Bạn vui lòng check mail để hoàn tất việc đăng ký.
									Chúc bạn thành công</p>
								<p>Lưu ý: Email có thể được gửi vào hộp thư spam</p>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>

		<footer>
			<div class="container"></div>
		</footer>
	</div>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/plugins.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/Script.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/modal.js" />"></script>
</body>
</html>