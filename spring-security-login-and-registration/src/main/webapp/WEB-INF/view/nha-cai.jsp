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
							<!-- end acc-wrap-left -->
							<div class="wrap-cua wrap-chan col-left">
													
								<span>1/${admindto.chan}</span>
								
								<div id="cua1" class="cuachan frmcuoc">
									<div class="frm-contentxu"></div>
									<span class="summonney">0</span>
								</div>
							</div>

							<!-- end wrap-chan -->
							<div class="wrap-cua wrap-le col-right">
													
								<span>1/${admindto.cuale}</span>
								
								<div id="cua2" class="cuale frmcuoc">
									<div class="frm-contentxu"></div>
									<span class="summonney">0</span>
								</div>
							</div>
							<!-- end wrap-le -->
							<div class="bg-xocdia">
								<div class="xocdia-wrap">
									<div class="timer active">
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
										<div class="frm-contentxu"></div>
										<span id="x3" class="summonney">0</span>
									</div>
								</div>
								<!-- end wrap-fblack -->
								<div class="wrap-cua marright7">
								<fmt:parseNumber var="nntd" integerOnly="true" 
                       			type="number" value="${admindto.tragbaden}" />
												
								<span>1/${admindto.tragbaden}</span>
								
									<div id="cua4" class="cuatback frmcuoc">
										<div class="frm-contentxu"></div>
										<span class="summonney">0</span>
									</div>
								</div>
								<!-- end cuatback -->
								<div class="wrap-cua marright7">
															
								<span>1/${admindto.denbatrang}</span>
							
									<div id="cua5" class="cuatwhite frmcuoc">
										<div class="frm-contentxu"></div>
										<span class="summonney">0</span>
									</div>
								</div>
								<!-- end cuatwhite -->
								<div class="wrap-cua marright7">
															
								<span>1/${admindto.bontrang}</span>
								
								
									<div id="cua6" class="cuafwhite frmcuoc">
										<div class="frm-contentxu"></div>
										<span class="summonney">0</span>
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
								<label id="oxu"></label>
								<label id="message"></label>
							</div>
							<div class="clear"></div>
							<div class="taikhoanxu">
								<span id="xunhacai">${user.xu} xu</span>
							</div>

							<div class="button-wrap">
								<button class="start" id="shortlyStart">Bắt đầu</button>
								<button class="clousehen" id="shortlyStart">Úp chén</button>
								<div class="clear"></div>
								<button onclick="Huyajax()" class="btn-bancua">Bán cửa</button>
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
		var biencua = 0;
		jQuery('#cua1').click(function(event) {
			biencua = 1;
			returnbien();
		});
		jQuery('#cua2').click(function(event) {
			biencua = 2;
			returnbien();
		});
		jQuery('#cua3').click(function(event) {
			biencua = 3;
			returnbien();
		});
		jQuery('#cua4').click(function(event) {
			biencua = 4;
			returnbien();
		});
		jQuery('#cua5').click(function(event) {
			biencua = 5;
			returnbien();
		});
		jQuery('#cua6').click(function(event) {
			biencua = 6;
			returnbien();
		});

		jQuery('.xu100').on('click', function(event) {
			returnbien(100);
		})
		jQuery('.xu50').on('click', function(event) {
			returnbien(50);
		})
		jQuery('.xu10').on('click', function(event) {
			returnbien(10);
		})
		jQuery('.xu5').on('click', function(event) {
			returnbien(5);
		})
		function returnbien(xu) {
			//console.log(biencua);
		}
		
		
	
	//tien = parseInt(tien, 10);	
	//console.log(tienx);
	/*
	function thongbao(){
		//tien = $('#xunhacai').html();
		tien = parseInt(tien, 10);	
		console.log(tien);
		console.log(restnew);
		if(tien < restnew){
			
			
			
			var bienT = restnew - tien;
			
			$('#message')
			.html(
					'<span class="emptyxu">Chúc mừng bạn đã thắng '+bienT +' xu !!!</span>');
			tien = $('#xunhacai').text();
		}if(tien > restnew){
									
			var bienTh = tien - restnew;
	
			$('#message')
			.html(
					'<span class="emptyxu">Bạn thua '+ bienTh +' xu !!!</span>');
			tien = $('#xunhacai').text();
		}
	}
	*/
		
		function loadnhacaixu() {
			$.ajax({
				url : 'xunhacaiload.html',
				success : function(data) {					
							
					//restnew =data;
					//restnew = parseInt(restnew, 10);
																
				
				$('#xunhacai').html(data + " xu");
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

		function Huyajax() {
			$.ajax({
				url : 'bancua/' + biencua,
				success : function(data) {
					// console.log(data);
				}
			});
		}

		var loadxu = 0;
		loadxu = setInterval(loadnhacaixu, 2000);

		var flatbancua = 1;
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
					
					var cua1 = $('#cua1 .summonney').html();
					if(res[9]==0){
						$('#cua1 .frm-contentxu>.addxu').remove();
					}
					if (cua1 < res[9]) {
						if ((res[9] - cua1) == 100) {
							autoXuPosition(1, 100);
						}
						if ((res[9] - cua1) == 50) {
							autoXuPosition(1, 50);
						}
						if ((res[9] - cua1) == 10) {
							autoXuPosition(1, 10);
						}
						if ((res[9] - cua1) == 5) {
							autoXuPosition(1, 5);
						}

					}

					$('#cua1 .summonney').html(res[9]);

					var cua2 = $('#cua2 .summonney').html();
					if(res[10]==0){
						$('#cua2 .frm-contentxu>.addxu').remove();
					}
					var check =  (res[10] - cua2);
					

						if (check == 100) {
							autoXuPosition(2, 100);
						}
						if (check == 50) {
							autoXuPosition(2, 50);
						}
						if (check == 10) {
							autoXuPosition(2, 10);
						}
						if (check == 5) {
							autoXuPosition(2, 5);
						}

					

					$('#cua2 .summonney').html(res[10]);

					var cua3 = $('#cua3 .summonney').html();
					if(res[11]==0){
						$('#cua3 .frm-contentxu>.addxu').remove();
					}
					if (cua3 < res[11]) {

						if ((res[11] - cua3) == 100) {
							autoXuPosition(3, 100);
						}
						if ((res[11] - cua3) == 50) {
							autoXuPosition(3, 50);
						}
						if ((res[11] - cua3) == 10) {
							autoXuPosition(3, 10);
						}
						if ((res[11] - cua3) == 5) {
							autoXuPosition(3, 5);
						}

					}

					$('#cua3 .summonney').html(res[11]);

					var cua4 = $('#cua4 .summonney').html();
					if(res[12]==0){
						$('#cua4 .frm-contentxu>.addxu').remove();
					}
					if (cua4 < res[12]) {

						if ((res[12] - cua4) == 100) {
							autoXuPosition(4, 100);
						}
						if ((res[12] - cua4) == 50) {
							autoXuPosition(4, 50);
						}
						if ((res[12] - cua4) == 10) {
							autoXuPosition(4, 10);
						}
						if ((res[12] - cua4) == 5) {
							autoXuPosition(4, 5);
						}

					}

					$('#cua4 .summonney').html(res[12]);

					var cua5 = $('#cua5 .summonney').html();
					if(res[13]==0){
						$('#cua5 .frm-contentxu>.addxu').remove();
					}
					if (cua5 < res[13]) {

						if ((res[13] - cua5) == 100) {
							autoXuPosition(5, 100);
						}
						if ((res[13] - cua5) == 50) {
							autoXuPosition(5, 50);
						}
						if ((res[13] - cua5) == 10) {
							autoXuPosition(5, 10);
						}
						if ((res[13] - cua5) == 5) {
							autoXuPosition(5, 5);
						}

					}

					$('#cua5 .summonney').html(res[13]);

					var cua6 = $('#cua6 .summonney').html();
					if(res[14]==0){
						$('#cua6 .frm-contentxu>.addxu').remove();
					}
					if (cua6 < res[14]) {

						if ((res[14] - cua6) == 100) {
							autoXuPosition(6, 100);
						}
						if ((res[14] - cua6) == 50) {
							autoXuPosition(6, 50);
						}
						if ((res[14] - cua6) == 10) {
							autoXuPosition(6, 10);
						}
						if ((res[14] - cua6) == 5) {
							autoXuPosition(6, 5);
						}

					}

					$('#cua6 .summonney').html(res[14]);
					
					

				}

			});
		}
		
		var restnew =0 ;	
		
		var tien =0  ;	
		
		var giay =$('#giys').html();
		function gettime() {
			$.ajax({
				url : 'gettime.html',
				success : function(data) {
					var str = data;
					var res = str.split(",");
					$('#phts').html(res[0]);
					$('#giys').html(res[1]);
					if (res[0] == 0 && res[1] == 10) {
						checktt();
						
						//tien = $('#xunhacai').html() ;
						$('.chenxocdia').addClass('Qwobble');
						disableE();
					}
					
					if (res[0] == 0 && res[1] == 9) {
						tien = tt;
					}
					
					if (res[0] == 0 && res[1] == 5) {
						$('.chenxocdia').removeClass('Qwobble');
						
						flatbancua = 1;
					}
					if (res[0] == 0 && res[1] == 2) {
						getnumber();
						
					}
					if (res[0] == 0 && res[1] == 1) {
						checktt();
					}
					if (res[0] == 0 && res[1] == 0) {
						
						restnew = tt;
						restnew = parseInt(restnew, 10);
						tien = parseInt(tien, 10);
						enableE();
						$('.chen').addClass('fadeOutUp animated');
						
						if(tien < restnew && tien !=0){
							//console.log(tien);
							//console.log(restnew);
							
							
							var bienT = restnew - tien;
							
							$('#message')
							.html(
									'<span class="emptyxu">Chúc mừng bạn đã thắng '+bienT +' xu !!!</span>');
							tien = $('#xunhacai').text();
						}if(tien > restnew && tien !=0){
													
							var bienTh = tien - restnew;
					
							$('#message')
							.html(
									'<span class="emptyxu">Bạn thua '+ bienTh +' xu !!!</span>');
							tien = $('#xunhacai').text();
						}
						clearInterval(intervalIdxx);
						
					}
					if (res[0] == 0 && res[1] <= 10) {
						
					}
					if (res[0] == 0 && res[1] == giay) {
						flatbancua = 0;

					}

				}
			});
		}

		function getnumber() {
			$.ajax({
				url : 'getnumber.html',
				success : function(data) {
					$('#hotxucxac').html(data);

				}
			});
		}
		
		function roiphong(id) {
			//console.log("ok");
			$.ajax({
				url : 'roiphong/' + id,
				success : function(data) {
					
				}
			});
		}
		
				
		
		function settime() {
			$('#message')
			.html('');
			$.ajax({
				url : 'settime.html',
				success : function(data) {
				}
			});
		}

		var intervalId = 0;
		intervalId = setInterval(loadnhacai, 1000);

		var intervalIdxx = 0;
		$('.start').click(function(event) {

			intervalIdxx = setInterval(gettime, 1000);
			$('#outroom').attr('onclick', 'return false').addClass('disabled');
			$(this).attr('disabled', 'disabled');
		});
		$('.clousehen').click(function(event) {
			$('#phts').html(0);
			$('#giys').html(giay);
			settime();
			intervalId = setInterval(loadnhacai, 1000);
			clearInterval(intervalIdxx);
			$(this).attr('disabled', 'disabled');
			$('.start').removeAttr('disabled');
			$('.addxu').remove();
			
		});

		
	</script>
	<script>
		function disableE() {
			//console.log("dddd");
			$('.btn-bancua').attr('disabled', 'disabled');
		}

		function enableE() {
			$('.btn-bancua,.clousehen').removeAttr('disabled');
			$('#outroom').attr('onclick', 'return true')
					.removeClass('disabled');
		}
	</script>
	<script>
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
		function autoXuPosition(cua, number) {
			randomPosition();
			$('#cua' + cua + ' .frm-contentxu')
					.append(
							"<div class='xu"+number+"app addxu' style='left: "+ seat+ ';'+ 'top:'+seat2 +"'></div>");

		}
	</script>
	<script>
	
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
		
	
	var tt =0;
	function checktt() {
		$.ajax({
			url : 'checktt.html',
			success : function(data) {
				 tt = data;
				
			}
		});
	}
	
		
	</script>
</body>
</html>