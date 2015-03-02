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
						<div class="login-page changepass">
							<h1>Đổi Mật Khẩu</h1>
							<form:form class="frm-form" modelAttribute="fp" method="POST" onsubmit="return checkinput();" name="changepass">
								<div class="frm-row">
									<label for="">Mật khẩu mới</label>
									<form:input id="password" path="pass" value="" type='password' />
									<form:errors path="pass" cssClass="alert alert-error"
										element="div" />
									<div class="clear"></div>
								</div>
								<div class="frm-row">
									<label for="">Nhập lại mật khẩu</label>
									<form:input id="repassword" path="repass" value="" type='password' />
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
	<script>
	window.onload = function(){
		/*------------- valid form register, design by Van Khuong ----------*/
				var inputs = document.forms['changepass'].getElementsByTagName('input');
				var run_onchange = false;
				function valid(){
					var errors = false; 
					
					for(var i=0; i<inputs.length; i++){
						var value = inputs[i].value;
						var id = inputs[i].getAttribute('id');
						
						// Tạo phần tử span lưu thông tin lỗi
						var span = document.createElement('span');
						// Nếu span đã tồn tại thì remove
						var p = inputs[i].parentNode;
						if(p.lastChild.nodeName == 'SPAN') {p.removeChild(p.lastChild);}
						
						// Kiểm tra rỗng
						if(value == ''){
							span.innerHTML ='Thông tin được yêu cầu';
						}else{
						// Kiểm tra các trường hợp khác
							
							// Kiểm tra password
							if(id == 'password'){
								if(value.length <6){span.innerHTML ='Password phải từ 6 ký tự';}
								var pass =value;
							}
							// Kiểm tra password nhập lại
							if(id == 'repassword' && value != pass){span.innerHTML ='Password nhập lại chưa đúng';}
							// Kiểm tra số điện thoại
							
						}
						
						// Nếu có lỗi thì span vào hồ sơ, chạy onchange, submit return false, highlight border
						if(span.innerHTML != ''){
							inputs[i].parentNode.appendChild(span);
							errors = true;
							run_onchange = true;
							inputs[i].style.border = '1px solid #c6807b';
							inputs[i].style.background = '#fffcf9';
						}
					}// end for
					
					if(errors == false){alert('Đăng ký thành công');}
					return !errors;
				}// end valid()
				
				// Chay ham kiem tra
				var register = document.getElementById('submit');
				register.onclick = function(){
					return valid();
				}
				
				// Kiểm tra lỗi với sự kiện onchange -> gọi lại hàm valid()
					for(var i=0; i<inputs.length; i++){
						var id = inputs[i].getAttribute('id');
						inputs[i].onchange = function(){
							if(run_onchange == true){
								this.style.border = '1px solid #999';
								this.style.background = '#fff';
								valid();
							}
						}
					}// end for
		}
	</script>
</body>
</html>