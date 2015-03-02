<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<!-- <header>
			<div class="container">
				<div class="row">
				</div>
			</div>
		</header>	 -->
<fmt:parseNumber var="i" integerOnly="true" 
                       type="number" value="${datcuoc.tongxu}" />
		<div id="content">
			<div class="container">
				<div class="row">
					<div class="content wrapbanchoi">
						<div class="tableplaycegame">
							<div class="acc-wrap-top">
								<div id="result1" class="chairhasacc marright35 acc1">
									<span class="no-acc"></span>
								</div>
								<div id="result2" class="chairhasacc marright35 acc2">
									<span class="no-acc"></span>
								</div>
								<div id="result3" class="chairhasacc marright35 acc3">
									<span class="no-acc"></span>
								</div>
								<div id="result4" class="chairhasacc marright35 acc4">
									<span class="no-acc"></span>
								</div>
								<div id="result5" class="chairhasacc marright35 acc5">
									<span class="no-acc"></span>
								</div>
								<div class="clear"></div>
							</div>
							<!-- end acc-wrap-top -->
							<div class="acc-wrap-right">
								<div id="result6" class="chairhasacc marright35 acc6">
									<span class="no-acc"></span>
								</div>
								<div id="result7" class="chairhasacc marright35 acc7">
									<span class="no-acc"></span>
								</div>
							</div>
							<!-- end acc-wrap-right -->
							<div class="acc-wrap-left">
								<div id="result8" class="chairhasacc marright35 acc8">
									<span class="no-acc"></span>
								</div>
								<div id="result9" class="chairhasacc marright35 acc9">
									<span class="no-acc"></span>
								</div>
							</div>
							<div class="wrap-cua wrap-chan col-left">
														
								<span>1/${admindto.chan}</span>
							
								<div id="cua1" class="cuachan frmcuoc">
									<div class="moidatcuoc">
										<span>Mời bạn click vào đây để đặt cược</span>
									</div>
									<div id="cua1_1" class="frm-contentxu"></div>
									<span id="xucua1" class="summonney">0</span>									
								</div>
							</div>

							<!-- end wrap-chan -->
							<div class="wrap-cua wrap-le col-right">
													
								<span>1/${admindto.cuale}</span>
								
								
								<div id="cua2" class="cuale frmcuoc">
									<div class="moidatcuoc">
										<span>Mời bạn click vào đây để đặt cược</span>
									</div>
									<div id="cua2_2" class="frm-contentxu"></div>
									<span id="xucua2" class="summonney">0</span>
								</div>
							</div>
							<!-- end wrap-le -->
							<div class="bg-xocdia">
								<div class="xocdia-wrap">
									<div class="timer">
										Bắt đầu cược: <span id="phts" class="countdown-section">${phut}</span>
										<span>:</span> <span id="giys" class="countdown-section">${giay}</span>
									</div>
									<div class="chenxocdia">
										<div class="diaxoc">
											<div id="hotxucxac" class="wrap-hotxucxac"></div>
										</div>
										<div class="chen"></div>
									</div>
								</div>
							</div>
							<!-- end xoc dia -->
							<div class="wrap-back-white">
								<div class="wrap-cua marright7">
																
								<span>1/${admindto.bonden}</span>
							
								
									<div id="cua3" class="cuafback frmcuoc">
										<div class="moidatcuoc">
											<span>Mời bạn click vào đây để đặt cược</span>
										</div>
										<div id="cua3_3" class="frm-contentxu"></div>
										<span id="xucua3" class="summonney">0</span>
									</div>
								</div>
								<!-- end wrap-fblack -->
								<div class="wrap-cua marright7">
								<fmt:parseNumber var="nntd" integerOnly="true" 
                       			type="number" value="${admindto.tragbaden}" />
												
								<span>1/${admindto.tragbaden}</span>
							
									
									<div id="cua4" class="cuatback frmcuoc">
										<div class="moidatcuoc">
											<span>Mời bạn click vào đây để đặt cược</span>
										</div>
										<div id="cua4_4" class="frm-contentxu"></div>
										<span id="xucua4" class="summonney">0</span>
									</div>
								</div>
								<!-- end cuatback -->
								<div class="wrap-cua marright7">
														
								<span>1/${admindto.denbatrang}</span>
								
									
									<div id="cua5" class="cuatwhite frmcuoc">
										<div class="moidatcuoc">
											<span>Mời bạn click vào đây để đặt cược</span>
										</div>
										<div id="cua5_5" class="frm-contentxu"></div>
										<span id="xucua5" class="summonney">0</span>
									</div>
								</div>
								<!-- end cuatwhite -->
								<div class="wrap-cua marright7">
															
								<span>1/${admindto.bontrang}</span>
								
								
									<div id="cua6" class="cuafwhite frmcuoc">
										<div class="moidatcuoc">
											<span>Mời bạn click vào đây để đặt cược</span>
										</div>
										<div id="cua6_6" class="frm-contentxu"></div>
										<span id="xucua6" class="summonney">0</span>
									</div>
								</div>
								<!-- end cuafwhite -->
							</div>
							<!-- end wrap-back-white -->
							<div class="thoatphong">
								<a id="outroom" href="<c:url value="phongcho.html" />">Phòng
									chờ</a>
								<div class="clear"></div>
							</div>
							<div class="showmess">
								<a id="oxu"></a>
								<a id="message"></a>
							</div>
							<div class="clear"></div>
							<div class="taikhoanxu">
								<span id="xu">${i} xu</span>
							</div>
							<div class="loaixu">
								<div class="xu100">
									<button onclick="crunchifyAjaxth(100)" class="btnxu100 btnaxu"
										value="100">
										<img src="<c:url value="/resources/css/images/100xu.png"/>"
											alt="">
									</button>
								</div>
								<div class="xu50">
									<button onclick="crunchifyAjaxth(50)" class="btnxu50 btnaxu">
										<img src="<c:url value="/resources/css/images/50xu.png"/>"
											alt="">
									</button>
								</div>
								<div class="xu10">
									<button onclick="crunchifyAjaxth(10)" class="btnxu10 btnaxu">
										<img src="<c:url value="/resources/css/images/10xu.png"/>"
											alt="">
									</button>
								</div>
								<div class="xu5">
									<button onclick="crunchifyAjaxth(5)" class="btnxu5 btnaxu">
										<img src="<c:url value="/resources/css/images/5xu.png"/>"
											alt="">
									</button>
								</div>
							</div>
							<div class="button-wrap">

								<div class="clear"></div>
								<button class="btn-datcuoc tablenguoichoi">Đặt cược</button>
								<button onclick="Huyajax(0)" class="btn-datlai  tablenguoichoi">Hủy
									một cửa</button>
								<button onclick="Huyajax(1)"
									class="btn-tanggapdoi  tablenguoichoi">Hủy tất cả</button>
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
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/jquery.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/plugins.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/script.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/modal.js" />"></script>

	<script type="text/javascript">
	var intervalId = 0;
	intervalId = setInterval(loadnhacai, 1000);
	function loadnhacai() {		
		$.ajax({
			url : 'nhacaiload.html',
			success : function(data) {
				var str = data;

				var res = str.split(",");
				$('#result1').html(res[0]);
				$('#result2').html(res[1]);
				$('#result3').html(res[2]);
				$('#result4').html(res[3]);
				$('#result5').html(res[4]);
				$('#result6').html(res[5]);
				$('#result7').html(res[6]);
				$('#result8').html(res[7]);
				$('#result9').html(res[8]);
			}

		});
	}
	
	
	
		var biencua = 0;
		jQuery('#cua1').click(function(event) {
			biencua = 1;

		});
		jQuery('#cua2').click(function(event) {
			biencua = 2;

		});
		jQuery('#cua3').click(function(event) {
			biencua = 3;

		});
		jQuery('#cua4').click(function(event) {
			biencua = 4;

		});
		jQuery('#cua5').click(function(event) {
			biencua = 5;

		});
		jQuery('#cua6').click(function(event) {
			biencua = 6;

		});

		function crunchifyAjaxth(xu) {
			if(biencua !=0){
			
			$('#message').html("");
			
			$
					.ajax({
						url : 'ajaxxu/' + biencua + '/' + xu,
						success : function(data) {
							var str = data;
							var res = str.split(",");
							if (res[0] == 0) {
								$('#oxu')
										.html(
												"<span class='emptyxu'>Bạn không đủ xu trong tài khoản !!!</span>");
								$('#xu').html(res[1] + " xu");
							} else if (res[0] == 2) {
								$('.frm-contentxu.active .addxu:last-child').remove();
								//console.log('sdfa');
								$('#oxu')
								.html(
										"<span class='emptyxu'>Nhà cái không đủ xu trong tài khoản !!!</span>");
						$('#xu').html(res[1] + " xu");
								
							} else {
								$('#xucua' + biencua).html(res[0]);
								$('#oxu').html(" ");
								$('#xu').html(res[1] + " xu");
							}
						}
					});
		}else{
			$('#message')
			.html(
					"<span class='emptyxu'> Mời bạn chọn cửa đặt !!!</span>");
		}
		}

		function Huyajax(i) {
			//console.log("huy");
			$.ajax({
				url : 'ajaxhuy/' + biencua + '/' + i,
				success : function(data) {
					var str = data;
					var res = str.split(",");
					if (i == 0) {
						$('#oxu').html(" ");
						$('#xucua' + biencua).html(res[0]);
						$('#xu').html(res[1]);
					} else {
						$('#oxu').html(" ");
						$('#xucua1').html(res[0]);
						$('#xucua2').html(res[0]);
						$('#xucua3').html(res[0]);
						$('#xucua4').html(res[0]);
						$('#xucua5').html(res[0]);
						$('#xucua6').html(res[0]);
						$('#xu').html(res[1] + " xu");
					}

				}
			});
		}
		
		var oldxu =0;
		var newxu =0;
		var intervalIdxx = 0;
		intervalIdxx = setInterval(gettime, 1000);
		function gettime() {
			//console.log("gettime");
			$.ajax({
				url : 'gettime.html',
				success : function(data) {
					var str = data;
					var res = str.split(",");
					$('#phts').html(res[0]);
					$('#giys').html(res[1]);
					if (res[0] == 0 && res[1] <= 10) {
						//$('.chenxocdia').addClass('Qwobble');
						disableE();
					}
					if (res[0] == 0 && res[1] == 10) {
						$('.chenxocdia').addClass('Qwobble');
						disableE();
						
					}
					if (res[0] == 0 && res[1] == 5) {
						$('.chenxocdia').removeClass('Qwobble');
						flatbancua =0;
						checktt();
						
					}
					if (res[0] == 0 && res[1] == 3) {
						oldxu = tt;
					}
					if (res[0] == 0 && res[1] == 1) {
						getnumber();
						checktt();
					}
					if (res[0] == 0 && res[1] == 0) {					
						flat = 1;
						$('#outroom').attr('onclick', 'return true')
						.removeClass('disabled');
						$('.chen').addClass('fadeOutUp animated');	
						newxu = tt;
						//console.log(newxu);
						//console.log(oldxu);
							newxu = parseInt(newxu, 10);
							oldxu = parseInt(oldxu, 10);
						if(newxu > oldxu && thoat == 0 ){
							var bienT = newxu - oldxu ;
							$('#oxu')
							.html(
									'<span class="emptyxu">Chúc mừng bạn đã thắng '+bienT +' xu !!!</span>');
							
						}
						if(newxu < oldxu && thoat ==0){
							var bienTh = oldxu - newxu;
							
							$('#oxu')
							.html(
									'<span class="emptyxu">Bạn thua '+ bienTh +' xu !!!</span>');
						}
					}
					if (res[0] == 0 && res[1] == giay) {
						$('.chen').removeClass('fadeOutUp animated').addClass(
								'fadeInDown animated');
						enableE();
						flatbancua =1;

					}

				}
			});
		}
		
		var giay =$('#giys').html();
		var flatbancua =1 ; 
		function loadnhacon() {
			$.ajax({
				url : 'isbancua.html',
				success : function(data) {
					var str = data;
					var res = str.split(",");
					var cua1 =$('#cua1 .summonney').html();
					if(cua1 !=0 && res[0]==0 && flatbancua ==1 ){
						$('#oxu')
						.html(
								'<span class="emptyxu">Nhà cái bán cửa CHẴN !!!</span>');
						$('#cua1_1').html('');
					}
					$('#xucua1').html(res[0]);
					
					var cua2 =$('#cua2 .summonney').html();
					if(cua2 !=0 && res[1]==0 && flatbancua ==1 ){
						$('#oxu')
						.html(
								'<span class="emptyxu">Nhà cái bán cửa LẺ !!!</span>');
						$('#cua2_2').html('');
						
					}
					$('#xucua2').html(res[1]);
					
					var cua3 =$('#cua3 .summonney').html();
					if(cua3 !=0 && res[2]==0 && flatbancua ==1 ){
						$('#oxu')
						.html(
								'<span class="emptyxu">Nhà cái bán cửa 4 ĐEN !!!</span>');
						$('#cua3_3').html('');
					}
					
					
					$('#xucua3').html(res[2]);
					
					var cua4 =$('#cua4 .summonney').html();
					if(cua4 !=0 && res[3]==0 && flatbancua ==1 ){
						$('#oxu')
						.html(
								'<span class="emptyxu">Nhà cái bán cửa 1 TRẮNG 3 ĐEN !!!</span>');
						$('#cua4_4').html('');
							
					}
					
					
					
					$('#xucua4').html(res[3]);
					
					
					
					var cua5 =$('#cua5 .summonney').html();
					if(cua5 !=0 && res[4]==0 && flatbancua ==1 ){
						$('#oxu')
						.html(
								'<span class="emptyxu">Nhà cái bán cửa 1 ĐEN 3 TRẮNG !!!</span>');
						$('#cua5_5').html('');
					}
					
					
					
					$('#xucua5').html(res[4]);
					
					var cua6 =$('#cua6 .summonney').html();
					if(cua6 !=0 && res[5]==0 && flatbancua ==1 ){
						$('#oxu')
						.html(
								'<span class="emptyxu">Nhà cái bán cửa 4 TRẮNG !!!</span>');
						$('#cua6_6').html('');
					}
					
					
					$('#xucua6').html(res[5]);
					$('#xu').html(res[6] + " xu");
					
					
				}
			});

		}
		
		var intervalIdbancua = 0;
		intervalIdbancua = setInterval(loadnhacon, 2000);
		var flat = 0;
		
		
		
		
		var xuthoat =0;
		var thoat =0;
		function close() {		
			$.ajax({
				url : 'isclose.html',
				success : function(data) {
					var str = data;
					var res = str.split(",");
					checktt();		
					if (res[0] == "1" && flat == 1) {						
						$('#xu').html(res[1] + " xu");
						$('#xucua1').html("0");
						$('#xucua2').html("0");
						$('#xucua3').html("0");
						$('#xucua4').html("0");
						$('#xucua5').html("0");
						$('#xucua6').html("0");
						$('#message')
						.html('');
						$('.btn-tanggapdoi').trigger('click');
						flat =0;
					}if(res[0] == " "){
						thoat =1;
						
						clearInterval(intervalId);
						clearInterval(intervalIdxx);
						 clearInterval(intervalIdbancua);												 
						// console.log("thoatphong");	
						 $('.chen').removeClass('fadeOutUp animated').addClass(
							'fadeInDown animated');
						 $('#phts').html("0");
							$('#giys').html("15");
						$('#oxu')
						.html(
								'<span class="emptyxu">Nhà cái thoát khỏi phòng !!!</span>');
						
						$('#xu').html(tt + " xu");
						 clearInterval(intervalIdclose);
					}

				}
			});
		}

		var intervalIdclose = 0;
		intervalIdclose = setInterval(close, 1000);

		function getnumber() {
			$.ajax({
				url : 'getnumber.html',
				success : function(data) {
					$('#hotxucxac').html(data);

				}
			});
		}
	</script>
	<script>
		// BTN XU CLICK
		// AUTO SEAT
		var seat;
		var seat2;
		function randomPosition() {
			gramppos = new Array()
			gramppos[0] = ("45%")
			gramppos[1] = ("30%")
			gramppos[2] = ("45%")
			gramppos[3] = ("60%")
			gramppos[4] = ("25%")
			gramppos[5] = ("45%")
			gramppos[6] = ("35%")
			gramppos[7] = ("50%")
			var Numb = Math.round(7 * Math.random());
			seat = gramppos[Numb];
			var Numb2 = Math.round(7 * Math.random());
			seat2 = gramppos[Numb2];
		}
		
		function checkxu() {
			var checkxu = $('#xu').text();
			checkxu = parseInt(checkxu, 10);
			return checkxu;
		}

		$('.xu100')
				.click(
						function(event) {
							randomPosition();
							var chX = checkxu();
							if (chX < 100) {
								$('#oxu')
										.html(
												'<span class="emptyxu">Không đủ xu trong tài khoản !!!</span>');
							} else {
								$('#oxu').html('');
								// AUTO SEAT
								
								if ($('.frm-contentxu').hasClass('active')
										&& $('.frm-contentxu').hasClass(
												'active')) {
									$('.frm-contentxu.active')
											.append(
													"<div class='xu100app addxu' style='left: "+ seat+ ';'+ 'top:'+seat2 +"'></div>");
								}
							}
						});
		$('.xu50')
				.click(
						function(event) {
							randomPosition();
							var chX = checkxu();
							if (chX < 50) {
								$('#oxu')
										.html(
												'<span class="emptyxu">Không đủ xu trong tài khoản !!!</span>');
							} else {
								$('#oxu').html('');
								if ($('.frm-contentxu').hasClass('active')
										&& $('.frm-contentxu').hasClass(
												'active')) {
									$('.frm-contentxu.active')
											.append(
													"<div class='xu50app addxu' style='left: "+ seat+ ';'+ 'top:'+seat2 +"'></div>");

								}
							}
						});
		$('.xu10')
				.click(
						function(event) {
							randomPosition();
							var chX = checkxu();
							if (chX < 10) {
								$('#oxu')
										.html(
												'<span class="emptyxu">Không đủ xu trong tài khoản !!!</span>');
							} else {
								$('#oxu').html('');
								if ($('.frm-contentxu').hasClass('active')
										&& $('.frm-contentxu').hasClass(
												'active')) {
									$('.frm-contentxu.active')
											.append(
													"<div class='xu10app addxu' style='left: "+ seat+ ';'+ 'top:'+seat2 +"'></div>");

								}
							}
						});
		$('.xu5')
				.click(
						function(event) {
							randomPosition();
							var chX = checkxu();
							if (chX < 5) {
								$('#oxu')
										.html(
												'<span class="emptyxu">Không đủ xu trong tài khoản !!!</span>');
							} else {
								$('#oxu').html('');
								if ($('.frm-contentxu').hasClass('active')
										&& $('.frm-contentxu').hasClass(
												'active')) {
									$('.frm-contentxu.active')
											.append(
													"<div class='xu5app addxu' style='left: "+ seat+ ';'+ 'top:'+seat2 +"'></div>");

								}
							}
						});

	</script>
	<script>
	
	
		function disableE() {
			$('.tablenguoichoi,.btnaxu').attr('disabled', 'disabled');
			$('#outroom').attr('onclick', 'return false').addClass('disabled');
		}

		function enableE() {
			$('.tablenguoichoi,.btnaxu,.clousehen').removeAttr('disabled');
			$('#outroom').attr('onclick', 'return true')
					.removeClass('disabled');
		}
	</script>
	
	<script>  
	var tt =0;
	function checktt() {
		$.ajax({
			url : 'checktt.html',
			success : function(data) {
				 tt = data;
				
			}
		});
	}
	
	function broweroff() {
		$.ajax({
			url : 'broweroff.html',
			success : function(data) {
			}
		});
	}

	
	
		window.onbeforeunload = function(e) {
			var e = e || window.event;
			//broweroff();	
			//IE & Firefox
			if (e) {
				//broweroff();
				e.returnValue = 'Bạn thật sự muốn thoát khỏi bàn chơi ?';
				broweroff();
			}
			else{
				
			}
			// For Safari
			
			
			return 'Bạn thật sự muốn thoát khỏi bàn chơi ?';
		};
	</script>
	
</body>
</html>