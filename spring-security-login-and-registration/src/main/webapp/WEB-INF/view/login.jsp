<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="messages" />
<%@ page session="true"%>
<fmt:message key="message.password" var="noPass" />
<fmt:message key="message.username" var="noUser" />

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/bootstrap.css" />" rel="stylesheet">
<title><spring:message code="label.pages.home.title"></spring:message></title>

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
							<h1>Đăng nhập</h1>
							<form class="frm-form" action="j_spring_security_check"
								method='POST' onsubmit="return validate();" name="login">
								<div class="frm-row">
									<label for="">Địa chỉ mail</label> <input type='text'
										name='j_username' id="email" value=''>
									<div class="clear"></div>
								</div>

								<div class="frm-row">
									<label for="">Mật khẩu</label><input id="" type='password'
										name='j_password' />
									<div class="clear"></div>
								</div>
								<div class="frm-row">
									<label for=""></label> <input type='checkbox'
										name='_spring_security_remember_me' /> Ghi nhớ tự đăng nhập
									cho lần sau
									<div class="clear"></div>
								</div>
								<div class="frm-row">
									<c:if test="${param.error == true}">
										<c:choose>
											<c:when
												test="${SPRING_SECURITY_LAST_EXCEPTION.message == 'Tài khoản chưa được kích hoat'}">
												<div class="alert alert-error">Tài khoản của bạn chưa
													được kích hoat, vui lòng kiểm tra email của ban để xác thực
													tài khoản</div>
											</c:when>
											<c:when
												test="${SPRING_SECURITY_LAST_EXCEPTION.message == 'User account has expired'}">
												<div class="alert alert-error">Token đăng ký của bạn
													đã hết hạn. vui lòng đăng ký lại.</div>
											</c:when>
											<c:otherwise>
												<span> Email hoặc mật khẩu không đúng </span>
											</c:otherwise>
										</c:choose>
									</c:if>
								</div>

								<div class="frm-row">
									<label for=""></label> <input name="submit" id="submit"
										type="submit" value="ĐĂNG NHẬP" />
									<div class="clear"></div>
								</div>

								<div class="frm-row">
									<label for=""></label> ${message}
									<div class="clear"></div>
								</div>

								<div class="frm-row">
									<label for=""></label> Bạn quên mật khẩu? <a
										href="<c:url value="/forgetpass" />">Click vào đây</a>
									<div class="clear"></div>
								</div>
							</form>

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
		window.onload = function() {
			/*------------- valid form register, design by Van Khuong ----------*/
			var inputs = document.forms['login'].getElementsByTagName('input');
			var run_onchange = false;
			function valid() {
				var errors = false;
				var reg_mail = /^[A-Za-z0-9]+([_\.\-]?[A-Za-z0-9])*@[A-Za-z0-9]+([\.\-]?[A-Za-z0-9]+)*(\.[A-Za-z]+)+$/;
				for (var i = 0; i < inputs.length; i++) {
					var value = inputs[i].value;
					var id = inputs[i].getAttribute('id');

					// Tạo phần tử span lưu thông tin lỗi
					var span = document.createElement('span');
					// Nếu span đã tồn tại thì remove
					var p = inputs[i].parentNode;
					if (p.lastChild.nodeName == 'SPAN') {
						p.removeChild(p.lastChild);
					}

					// Kiểm tra rỗng
					if (value == '') {
						span.innerHTML = 'Thông tin được yêu cầu';
					} else {
						// Kiểm tra các trường hợp khác
						if (id == 'email') {
							if (reg_mail.test(value) == false) {
								span.innerHTML = 'Email không hợp lệ (ví dụ: abc@gmail.com)';
							}
							var email = value;
						}

					}

					// Nếu có lỗi thì span vào hồ sơ, chạy onchange, submit return false, highlight border
					if (span.innerHTML != '') {
						inputs[i].parentNode.appendChild(span);
						errors = true;
						run_onchange = true;
						inputs[i].style.border = '1px solid #c6807b';
						inputs[i].style.background = '#fffcf9';
					}
				}// end for

				return !errors;
			}// end valid()

			// Chay ham kiem tra
			var register = document.getElementById('submit');
			register.onclick = function() {
				return valid();
			}

			// Kiểm tra lỗi với sự kiện onchange -> gọi lại hàm valid()
			for (var i = 0; i < inputs.length; i++) {
				var id = inputs[i].getAttribute('id');
				inputs[i].onchange = function() {
					if (run_onchange == true) {
						this.style.border = '1px solid #999';
						this.style.background = '#fff';
						valid();
					}
				}
			}// end for
		}// end onload
	</script>
</body>
</html>