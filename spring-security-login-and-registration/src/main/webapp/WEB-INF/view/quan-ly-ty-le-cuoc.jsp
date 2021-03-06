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
						<div class="admin-wrap">
							<div class="admin-left-content">
								<h3>Quản lý thành viên</h3>
								<ul>
									<li><a href="admin.html">Danh sách thành viên</a></li>
									<li><a href="<c:url value="/napxu" />">Nạp xu</a></li>
									<li><a href="<c:url value="/list-thanh-vien-rut-tien" />">Thành viên rút tiền</a></li>
									
								</ul>
								
								<h3>Quản lý bàn chơi</h3>
								<ul>
									<li><a href="<c:url value="/quan-ly-ty-le-cuoc" />">Quản lý tỷ lệ cược</a></li>								
									<li><a href="<c:url value="/ql-thoi-gian-dem-nguoc" />">Quản lý thời gian</a></li> 
									<li><a href="<c:url value="/ql-hoa-hong" />">Quản lý hoa hồng</a></li> 
								</ul>								
								<h3>Quản lý đăng tin</h3>
								<ul>									
									<li><a href="<c:url value="/admin-huong-dan-choi-game" />">Hướng dẫn chơi game</a></li>
									<li><a href="<c:url value="/admin-huong-dan-nap-xu" />">Hướng dẫn nạp xu</a></li>  
								</ul>
								
								<h3>Quản lý Admin</h3>
								<ul>
									<li><a href="<c:url value="/changepass" />">Đổi mật khẩu</a></li>
									<li><a href="<c:url value="/admin-Reset-Server" />">Reset lại server</a></li>
								</ul>
							</div>
							<div class="admin-right-content">
								<h2>Quản lý tỷ lệ cược</h2>
	
								<div class="frm-napxu">
								<form:form class="frm-form tylecuoc"  modelAttribute="admin" method="POST" >
										<div class="frm-row">
											<label for="">Cửa chẳn:</label>
											<span>1 ăn</span><form:input path="chan" value="" />
										</div>
										<div class="frm-row">
											<label for="">Cửa lẻ:</label>
											<span>1 ăn</span><form:input path="cuale" value="" />
										</div>
										<div class="frm-row">
											<label for="">Cửa 4 đen:</label>
											<span>1 ăn</span><form:input path="bonden" value="" />
										</div>
										<div class="frm-row">
											<label for="">Cửa 1 đen 3 trắng:</label>
											<span>1 ăn</span><form:input path="denbatrang" value="" />
										</div>
										<div class="frm-row">
											<label for="">Cửa 1 trắng 3 đen:</label>
											<span>1 ăn</span><form:input path="tragbaden" value="" />
										</div>
										<div class="frm-row">
											<label for="">Cửa 4 trắng:</label>
											<span>1 ăn</span><form:input path="bontrang" value="" />
										</div>  
										<div class="frm-row">
											<label for=""></label>
										<span class="thongbao">${message } </span>
										</div>
										<div class="frm-row">
											<label for=""></label>
											<input class="xacnhan" type="submit" value="Xác nhận">
										</div>
									</form:form>
								</div>
							</div>
							<div class="clear"></div>
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
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/jquery.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/plugins.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/script.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/modal.js" />"></script>
	<!-- <div id="preview-area">
		<div class="spinner">
		  <div class="bounce1"></div>
		  <div class="bounce2"></div>
		  <div class="bounce3"></div>
		</div>
	</div> -->
</body>
</html>