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
		<link href="<c:url value="/resources/css/reset.css" />"
	rel="stylesheet" type="text/css" />
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
									<li><a href="<c:url value="/admin-huong-dan-choi-game" />">Hướng dẫn nạp xu</a></li>  
								</ul>
								
								<h3>Quản lý Admin</h3>
								<ul>
									<li><a href="<c:url value="/changepass" />">Đổi mật khẩu</a></li>
									<li><a href="<c:url value="/admin-Reset-Server" />">Reset lại server</a></li>
								</ul>
							</div>
							<div class="admin-right-content">
								<h2>Nạp xu</h2>
								<div class="frm-napxu">	
								 <form:form class="frm-form"  modelAttribute="userdto">						
										<div class="frm-row">
											<label for="">Mã thành viên</label>
										<form:input path="id" />
										</div>
										<div class="frm-row">
											<label for=""></label>
											 <input type="submit" value="Tìm kiếm"/>
											
										</div>
										<div class="frm-row">
											<label for=""></label>
											<span id="message" class="thongbao">${message}</span>
										</div>		
							</form:form>				
								</div>
								<div class="frm-napxu">
								<form:form class="frm-form"  modelAttribute="userdto">	
										<div class="frm-row">
											<label for="">Mã thành viên:</label>
											<form:input path="id" readonly="true" value="${userdto.id}" />
										</div>
										
										<div class="frm-row">
											<label for="">Tên thành viên:</label>
											<form:input path="fullname" readonly="true" value="${userdto.fullname}" />
											
										</div>
										<div class="frm-row">
											<label for="">Email:</label>
											<form:input path="email" readonly="true" value="${userdto.email}" />
										 
										</div>
										<div class="frm-row">
											<label for="">Số điện thoại:</label>
											<form:input path="phone" readonly="true" value="${userdto.phone}" />
											
										</div>
										<div class="frm-row">
											<label for="">Số xu hiện có:</label>
											<form:input path="xu" readonly="true" value="${userdto.xu}" />
											 
											<label id="xunhap" class="thongbao" for=""></label>
										</div>
										<div class="frm-row">
											<label for="">Nhập số xu muốn nạp:</label>
											 <form:input path="xunap" />
										</div>
										<div class="frm-row">
											<label for=""></label>
											 <input type="submit" value="Nạp xu"/>
											
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
	
	<script type="text/javascript" > 
	
	//var matv = $('#seachmatv').val();	
	/*
	var abc = $('#seachmatv').val('0');
	var xx = abc.val();
		function timkiem() {
			//msgthongbao();
			
			$.ajax({
				contentType : "application/x-www-form-urlencoded; charset=UTF-8" ,
				url : 'timkiem/'+ abc.val() ,
				success : function(data) {
					//console.log(matv);
					var str = data;
					var res = str.split(",");
				if(res[0]==0){
					$('#messageno').html("Không tìm thấy thành viên");
					$('#idmatv').val("");
					
					$('#idemail').val("");
					$('#idphone').val("");
					$('#idxu').val("");
				}else{
					$('#idmatv').val(res[0]);
					$('#idten').val(res[1]);
					$('#idemail').val(res[2]);
					$('#idphone').val(res[3]);
					$('#idxu').val(res[4]);
				}

				}
			});
		}
		
		
		
		var xu = $('#idxunhap').val('0');		
		function napxuajax() {
			$.ajax({
				url : 'napxuajax/' + xu.val() +'/' +abc.val()  ,
				success : function(data) {
					
					$('#idxu').val(data);  
					$('#xunhap').html("Nạp Xu thành công");

				}
			});
		}
	*/
		</script>	
</body>
</html>