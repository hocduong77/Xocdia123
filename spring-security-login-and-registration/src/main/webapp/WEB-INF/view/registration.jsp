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
	<link href="<c:url value="/resources/css/reset.css" />"rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
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
						
							<form:form class="frm-form"  modelAttribute="user" method="POST" enctype="multipart/form-data">
								<h1>Đăng ký thành viên</h1>
								<div class="frm-row">
									<label for="">Nick Name</label>
									<form:input path="firstName" value="" placeholder="Nickname nhập không dấu, không khoảng trắng" />
									<form:errors path="firstName" cssClass="spanhide"
										element="div" />
									
									<div class="clear"></div>
								</div>
								
								<div class="frm-row">
											<label for="">Thay hình đại diện:</label>
											<input type="file" name="file">
											<div class="clear"></div>
										</div>
								<div class="frm-row">
									<label for="">Mật khẩu</label>
									<form:input path="password" value="" type="password" />
									<form:errors path="password" cssClass="spanhide"
										element="div" />
									<div class="clear"></div>
								</div>
								<div class="frm-row">
									<label for="">Nhập lại mật khẩu</label>
									<form:input path="matchingPassword" value="" type="password" />

									<form:errors cssClass="spanhide" element="div" />
									<div class="clear"></div>
								</div>
								<div class="frm-row">
									<label for="">Địa chỉ mail</label>
									<form:input path="email" value="" />
									<form:errors path="email" cssClass="spanhide"
										element="div" />
									<div class="clear"></div>
								</div>
								<div class="frm-row">
									<label for=""></label>
									<form:checkbox path="accept"></form:checkbox> Tôi đồng ý với <a href="">quy đinh của website</a>
									<div class="clear"></div>
								</div>
								<div class="frm-row">
									<label for=""></label>
									<span class="smg-error">${error}</span>
									<div class="clear"></div>
								</div>
								
								<div class="frm-row">
								<label for=""></label>
									<input type="submit" value="Đăng ký">
									<div class="clear"></div>
								</div>
							</form:form>
							
						</div>
					</div>
				</div>
			</div>
		</div>	

		<footer>
			<div class="container">
			</div>
		</footer>
	</div>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/scripts/plugins.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/scripts/Script.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/scripts/modal.js" />"></script>
</body>
</html>