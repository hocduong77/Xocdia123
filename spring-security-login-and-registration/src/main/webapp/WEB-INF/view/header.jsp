<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="messages" />

<fmt:message key="message.password" var="noPass" />
<fmt:message key="message.username" var="noUser" />
	<header>
			<div class="container">
				<div class="row">
					<div class="navtop">
					<div class="homeicon">
							<a href="<c:url value="home.html" />">Trang chủ</a>
						</div>
						<div class="login-wrap">
						<sec:authorize access="isAuthenticated()">
						<div class="user">
								<a href="<c:url value="/thong-tin-thanh-vien" />">${user.firstName}</a>
							</div>		
							</sec:authorize>				
						<sec:authorize access="isAnonymous()">
							
							<div class="register">
							
								<a href="<c:url value="/registration" />">Đăng ký</a>
							</div>
							</sec:authorize>
							<sec:authorize access="isAnonymous()">
							<div class="login">
								<a href="<c:url value="login.html" />">Đăng nhập</a>
							</div>
							</sec:authorize>
							
						</div>
						<sec:authorize access="isAuthenticated()">
						<div class="logout">
							<a href="<c:url value="/j_spring_security_logout" />">Thoát</a>
						</div>
						</sec:authorize>
						<div class="help">
							<a href="<c:url value="huong-dan-choi-game" />">Hướng dẫn</a>
						</div>
						
					</div>
				
					<div class="nav-main">
						<div class="main-nav"><a class="napxu" href="" data-toggle="modal" data-target="#myModal">Nạp xu</a></div>
						<div class="main-nav khuyenmai">
							<div class="item-news">
								<div class="item-new">
									
								</div>
							</div>
						</div>
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
</div>
