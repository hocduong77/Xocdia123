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
								<a href="<c:url value="/thong-tin-thanh-vien" />">${user.firstName}</a>
						</div>
						<div class="logout">
							<a href="<c:url value="/j_spring_security_logout" />">Thoát</a>
						</div>
						<div class="help">
							<a href="<c:url value="huong-dan-choi-game" />">Hướng dẫn</a>
						</div>
					</div>
				
					<div class="nav-main">
						<div class="main-nav"><a class="xuhienco" href="">Bạn có: ${users.xu}  Xu</a></div>
						<div class="main-nav"><a class="napxu" href="" data-toggle="modal" data-target="#myModal">Nạp xu</a></div>
						<!-- popup -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="myModalLabel">${admin.napxutitile}</h4>
						      </div>
						      <div class="modal-body">
						      ${admin.napxueditor}
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
								<div class="col-xs-6">
									<div class="zone-acc-info">Thông tin chung</div>
									<form:form class="frm-form" modelAttribute="user" method="POST"
										enctype="multipart/form-data">
										<div class="frm-row">
											<label for="">Hình đại diện</label>
											<div class="fileinput fileinput-new" data-provides="fileinput">
											  <div class="fileinput-preview thumbnail" data-trigger="fileinput">
											  	<img alt="" src="<c:url value="${users.lastName }"/>">
											  </div>
											</div>
											<div class="clear"></div>
										</div>
										<div class="frm-row">
											<label for="">Thay hình đại diện:</label>
											<input type="file" name="file">
											<div class="clear"></div>
										</div>
										<div class="frm-row">
											<label for="">Id:</label>
											<form:input path="id" readonly="true" value="${user.id}" />
											<div class="clear"></div>
										</div>
										<div class="frm-row">
											<label for="">Tên đăng nhập:</label>
											<form:input path="firstName" value="${user.firstName}" />
											<div class="clear"></div>
										</div>
										<div class="frm-row">
											<label for="">Họ và tên:</label>
											<form:input path="fullname" value="${user.fullname}" />
											<div class="clear"></div>
										</div>
										<div class="frm-row">
											<label for="">Số điện thoại:</label>
											<form:input path="phone" value="${user.phone}" />
											<div class="clear"></div>
										</div>
										<div class="frm-row">
											<label for="">Email:</label>
											<form:input path="email" readonly="true" value="${user.email}" />
											<div class="clear"></div>
										</div>
										<div class="frm-row">
											<label for=""></label> <a
												href="<c:url value="/changepass" />">Đổi mật khẩu</a>
											<div class="clear"></div>
										</div>
										<div class="frm-row">
											<label for=""></label>
											<span class="xurut thongbao">${thongbao}</span>
											<div class="clear"></div>
										</div>
										
										<div class="frm-row">
											<label for=""></label>
											<input type="submit" value="Cập nhật">
											<div class="clear"></div>
										</div>
									</form:form>
									<div class="clear"></div>
								</div>
								<!-- end ban vip -->
								<div class="col-xs-6">
									<div class="zone-bank-info">Yêu cầu rút tiền</div>
									<form action="" class="frm-form">
										<div class="frm-row">
											<label for="" class="curentlabel">Tổng số xu bạn có:</label>
											<span  id="idxu" class="curencent">${users.xu}</span>
											<div class="clear"></div>
										</div>
										<div class="frm-row">
											<label for="">Nhập số xu muốn rút:</label> <input id="idxunhap" type="text">
											<div class="clear"></div>
										</div>
										
										<div class="frm-row">
										<label for=""></label>
										<span class="note">Số xu muốn rút tối thiểu là 100 xu,
												tỷ lệ xu/tiền là 1xu/10.000đ</span>
										</div>
										<div class="frm-row">
											<label for=""></label>
											<span id="xurut" class="xurut"></span>
										</div>
										
										<div class="frm-row">
											<label for=""></label>
											<input class=""  onclick="napxuajax()" type="button" value="Rút xu">
											<div class="clear"></div>
										</div>
										
										<c:if test="${user.ruttien > 0}">
										<div style="border-top:1px dotted #999;border-bottom:1px dotted #999;padding:15px 0;margin-top:20px;">
										
										<div class="frm-row">
										<label for="">Số xu bạn muốn hủy</label>										
										<span id="xudarut" class="xurut">${user.ruttien}</span>
										</div>
										<div class="frm-row">
											<label for=""></label>
											<input class=""  onclick="huyxudarut()" type="button" value="Hủy rút xu">
											<div class="clear"></div>
										</div>
										</div>
										</c:if>
									</form>
									<div class="clear"></div>
								</div>
								<!-- end ban thuong -->
								<div class="clear"></div>
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
			
			<script >
			var xu = $('#idxunhap').val('0');		
			function napxuajax() {
				
				$.ajax({
					url : 'rutxu/' + xu.val()  ,
					success : function(data) {
						var str = data;
						var res = str.split(",");
						
						$('#idxu').html(res[0]);
						
						if(res[1] ==1 ){
						$('#xurut').html("Không được rút nhỏ hơn 100 xu");
						}
						if(res[1] ==2 ){
							$('#xurut').html("Không được rút lớn hơn tài khoản");
							}
						if(res[1] ==3 ){
							$('#xurut').html("Tổng xu bạn rút là: " + res[2] );
							}
						

					}
				});
			}
			
			var xuhuy = $('#xudarut').html();		
			function huyxudarut() {
				console.log(xuhuy);
				$.ajax({
					url : 'huyxudarut/' + xuhuy  ,
					contentType: "charset=ISO-8859-15",
					success : function(data) {
						var str = data;
						var res = str.split(",");
						$('#xudarut').html("0");
						$('#idxu').html(res[0]);
						if(res[1] ==1 ){
						$('#xurut').html("Đã hủy rút xu");
						}
						

					}
				});
			}
			
			
			</script>
</body>
</html>