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
					<div class="navtop">
					<div class="homeicon">
							<a href="<c:url value="home.html" />">Trang chủ</a>
						</div>
						<div class="login-wrap">

							<div class="user">
								<a href="<c:url value="/thong-tin-thanh-vien" />">${user.firstName}</a>
							</div>
						</div>
						<div class="logout">
							<a href="<c:url value="/j_spring_security_logout" />">Thoát</a>
						</div>
						<div class="help">
							<a href="<c:url value="huong-dan-choi-game" />">Hướng dẫn</a>
						</div>
					</div>

					<div class="nav-main">
						<div class="main-nav">
							<a class="xuhienco" href="">Bạn có: ${user.xu} Xu</a>
						</div>
						<div class="main-nav">
							<a class="napxu" href="" data-toggle="modal"
								data-target="#myModal">Nạp xu</a>
						</div>

						<!-- popup -->
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
						<div class="listroom-wrap">
							<div class="zone-vip">Tạo bàn chơi mới</div>
							<div class="col-sm-12 creatban">
								<div class="note">Lưu ý: Người tạo bàn mới mặc định là nhà
									cái.</div>
								<div class="col-sm-3"></div>
								<div class="col-sm-9">
									<form:form modelAttribute="phong" method="POST">
										<div class="frm-row">
											<label for="">Mã bàn</label>
											<form:input path="maBan" readonly="true"  value="" />

										</div>
										
										<div class="frm-row">
											<label for="">Số xu tối thiểu</label>											
											<form:input path="xuToiThieu" value="" />
											<span class="thongbao">${error}</span>										
										</div>
										
										<div class="frm-row">
											<label for="">Tổng Số người</label>
											<form:select path="soNguoi" items="${soNguoi}">   </form:select>
											
												<div class="frm-row">
													<label for=""></label> <input type="submit"
														value="Tạo phòng">
												</div>
									</form:form>
								</div>
								<div class="clear"></div>
							</div>
						</div>
						<div class="clear"></div>
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