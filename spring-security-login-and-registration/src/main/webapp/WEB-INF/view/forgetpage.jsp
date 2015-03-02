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
		<header>
			<div class="container">
				<div class="row">
					<%@ include file="header.jsp"%>

					<div class="nav-main">
						<div class="main-nav">
							<a class="napxu" href="" data-toggle="modal"
								data-target="#myModal">Nạp xu</a>
						</div>
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">${admin.napxutitile}</h4>
						      </div>
						      <div class="modal-body">
						      ${admin.napxueditor}
						      </div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
						<!-- end popup -->
					</div>
				</div>
			</div>
		</header>

		<div id="content">
			<div class="container">
				<div class="row">
					<div class="content">
						<div class="login-page">
							<h1>Đổi Mật Khẩu</h1>
							<form:form class="frm-form" modelAttribute="form" method="POST">
								<div class="frm-row">
									<label for="">Mật khẩu mới</label>
									<form:input path="pass" value="" type='password' />
									<form:errors path="pass" cssClass="alert alert-error"
										element="div" />
									<div class="clear"></div>
								</div>
								<div class="frm-row">
									<label for="">Nhập lại mật khẩu</label>
									<form:input path="repass" value="" type='password' />
									<form:errors path="repass" cssClass="alert alert-error"
										element="div" />
										<label for="">${mesage}</label>
									<div class="clear"></div>
								</div>
								<div class="frm-row">
									<label for=""></label>
									<input id="submit" type="submit" value="Cập nhật">
									<div class="clear"></div>
								</div>
							</form:form>
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