//网游详情页安卓苹果多个版本
$(function(){
$(".androiddown span").click(
  function(){
    $(".androiddown .androidShow").toggle();
  $(this).parent().css('z-index',1);
  $(this).parent().siblings().css('z-index',0);
  }
);
$(".iosdown span").click(
  function(){
    $(".iosdown .androidShow").toggle();
  $(this).parent().css('z-index',1);
  $(this).parent().siblings().css('z-index',0);
  }
);
})
//==========================================================zhuhh begin
$(function() {
    $(document).click(function(e) {

        var $androidShow = $('.androiddown .androidShow');
        var $iosShow = $('.iosdown .androidShow');

        if(!$(e.target).is('.androiddown span')) {
          if($androidShow.is(':visible')) {
            $androidShow.hide();
          }
        }

        if(!$(e.target).is('.iosdown span')) {
          if($iosShow.is(':visible')) {
            $iosShow.hide();
          }
        }     
    });
})
//==========================================================zhuhh end

