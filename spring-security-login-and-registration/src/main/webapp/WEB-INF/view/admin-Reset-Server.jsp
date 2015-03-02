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
								<h2>Quản lý % hoa hồng</h2>
								<div class="qlhh">
									<form:form class="frm-form tylecuoc"  modelAttribute="admin" method="POST" >
										<div class="frm-row">
											<label for="">Trong trường hợp sever bị lỗi, hoặt mất mạng ....
											click nút reset bên dưới để reset lại sever. Lưu ý, các thông tin về phòng chơi, đăt cược sẽ bị xóa sau khi bạn click nút reset.
											</label>											
										</div>
										<div class="frm-row">
											<label for=""></label>
										<span id="reset" class="thongbao"></span>
										</div>
										<div class="frm-row">
											<label for=""></label>
											<input class=""  onclick="resetjax()" type="button" value="Reset">	
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
		<script>
	function resetjax() {
			$.ajax({
				url : 'resetjax.html'  ,
				success : function(data) {
					if(data ==0){
						$('#reset').html("Reset thành công");
					}
					

				}
			});
		}
	</script>
</body>
</html>