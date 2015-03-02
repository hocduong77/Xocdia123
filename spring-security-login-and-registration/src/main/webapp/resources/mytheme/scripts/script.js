;var wdH=0, wdW=0,isie= false,apis = [];var api;

winresize = function(){
    wdW = $(window).width();
    wdH = $(window).height();    
}

function autoCutStr(prefix) {
    if (!prefix || prefix === undefined) {
        prefix = "autoCutStr_";
    }
    $('[class^="' + prefix + '"]').each(function () {
        if ($(this).length > 0) {
            var str = $(this).html();
            str = str.replace('<br/>','');
            str = str.replace('<br>','');
            $(this).html(str);
            var len = parseInt($(this).attr("class").substr($(this).attr("class").lastIndexOf("_") + 1));
            var length = str.length;
            if (length > len) {
                if (str.charAt(len) == ' ') {
                    str = str.substr(0, len);
                }
                else {
                    str = str.substr(0, len);
                    str = str.substr(0, str.lastIndexOf(" "));
                }
                $(this).html(str + "...");
            }
        }
        
    });
}

$(document).ready(function() {
    jQuery('.vaolistphong').mouseenter(function(event) {
      jQuery('.vaolistphong').addClass('shake animated');
    }).mouseleave(function(event) {
       jQuery('.vaolistphong').removeClass('shake animated');
    });

    jQuery('.frmcuoc').click(function(event) {
       jQuery('.frmcuoc,.frm-contentxu').removeClass('active');
       $(this).addClass('active').find('.frm-contentxu').addClass('active');
    });

    $('.moidatcuoc').click(function(event) {
      $('.moidatcuoc').hide();
    });
    $('.btn-datcuoc').click(function(event) {
      $('.moidatcuoc').css('display','table');
    });
    
    $('.btn-bancua').click(function(){
    	if($('.tableplaycegame').find('.frmcuoc').hasClass("active")){
    		$('.frmcuoc.active .addxu').remove();
    	}
    	else{
    		alert('Bạn chưa chọn cửa muốn bán!!!');
    	}	
    });
    //UP CHEN
    $('.clousehen').click(function(event) {
      $('.chen').removeClass('fadeOutUp animated').addClass('fadeInDown animated');
    });

    // HUY DAT CUOC
    $('.btn-datlai').click(function(event) {
      if($('.frm-contentxu').hasClass('active') && $('.frm-contentxu').hasClass('active')){
          $('.frm-contentxu.active').find('.addxu').remove();
      }
    });

    // HUY TẤT CẢ XU ĐÃ ĐẶT Ở TẤT CẢ CÁC CỦA
    $('.btn-tanggapdoi').click(function(event) {
      $('.frm-contentxu').find('.addxu').remove();
    });
  
   

    $('.waitting').click(function() {
      $('body').append('<div id="preview-area"><div class="spinner"><div class="bounce1"></div><div class="bounce2"></div><div class="bounce3"></div></div></div>');
    });
    
    $('.msgbtn').click(function(){
    	console.log('asdfasdf');
		$('.msgthongbao-wrap').css('display','none');
	});
   /* $('.main-nav').click(function(){
    	$('.modal-title').html('Nạp xu');
    	$('.modal-body').html("Bạn muốn nạp xu, vui lòng liên hệ Mr. Toan. Số điện thoại liên lạc 3245363454324");
    });*/
    
    
});


$(window).load(function() {
//  UP AN UP CHEN KHI MOI VAO
    $('.clousehen').attr('disabled','disabled');
});
