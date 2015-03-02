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
									<li><a href="<c:url value="/admin-huong-dan-nap-xu" />">Hướng dẫn nạp xu</a></li> 
								</ul>
								
								<h3>Quản lý Admin</h3>
								<ul>
									<li><a href="<c:url value="/changepass" />">Đổi mật khẩu</a></li>
									<li><a href="<c:url value="/admin-Reset-Server" />">Reset lại server</a></li>
								</ul>
							</div>
							<div class="admin-right-content">
								<h1>Thành viên rút tiền</h1>
								<table>
									<tr class="tr-head">
										<td>Ngày</td>
										<td>Mã</td>
										<td>Thành Viên</td>
										<td class="textright">Điện thoại</td>
										<td class="textright">Tiền thực có</td>
										<td class="textright">Xu yêu cầu rút</td>
										<td class="textright">Xu còn lại</td>
										<td class="center">Tình trạng</td>
									</tr>
									<c:forEach var="elem" items="${elements}">
									<c:if test="${elem.ruttien > 0  }">
									<tr>
										<td>01/01/04</td>
										<td>${elem.id}</td>
										<td>${elem.fullname}</td>
										<td class="textright">${elem.phone}</td>
										<td class="textright">${elem.xu}</td>
										<td class="textright">${elem.ruttien}</td>
										<td class="textright">${elem.xu - elem.ruttien}</td>
										
										<c:if test="${elem.status == 0}">
										<td class=""><span class="hasbutton">Yêu cầu mới</span> <a class="btnactive btnewrequest" href="<c:url value="dat-lenh-rut-tien/${elem.id}" />">Chuyển tiền</a></td>
										</c:if>
									</tr>
									</c:if>
									<c:if test="${elem.tiendachuyen > 0}">
									<tr>
										<td>01/01/04</td>
										<td>${elem.id}</td>
										<td>${elem.fullname}</td>
										<td class="textright">${elem.phone}</td>
										<td class="textright">${elem.xu}</td>
										<td class="textright">${elem.tiendachuyen}</td>
										<td class="textright">${elem.xu - elem.ruttien}</td>
										
										
										<c:if test="${elem.statusdachuyen == 1}">
										<td class=""><span class="hasbutton">Đang chuyển</span><a class="btnactive" onclick="setstatus(${elem.id})">Hoàn tất</a></td>
										</c:if>
										<c:if test="${elem.statusdachuyen == 2}">
										<td class=""><span class="hasbutton">Đã chuyển</span> <span class="finished"><i class="fa fa-check-circle fx-2x"></i></span></td>
										</c:if>
									</tr>
									
									</c:if>
									</c:forEach>
									
								</table>
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
		<script >
		var matv ;			
			function setstatus(matv) {
				$.ajax({
					url : 'setstatus/'+matv  ,
					success : function(data) {
						
						

					}
				});
			}
		</script>
	
</body>
</html>