// JavaScript Document
//展开收起
$(function(){ 
  $('.downsubconShow .downsubconShowtop').find('span').addClass('upshow');
  $('.downsubconShow .downsubconShowtop').click(function(){
    var $onCon=$(this).siblings('.downsubconShowcon');
  if($onCon.is(':visible')){
    $(this).find('span').addClass('downhide');
      $(this).find('span').removeClass('upshow');
    $onCon.hide();
  }else{
    $(this).find('span').addClass('upshow');
      $(this).find('span').removeClass('downhide');
    $onCon.show();
    }
  });
  $('.code').hover(function(){
    $(this).siblings('.codeCon').show();     
	$(this).parents('.downsubconShow').css("z-index","1");
	$(this).parents('.downsubconShow').siblings().css('z-index','0');
  },function(){
    $(this).siblings('.codeCon').hide();     
  });
  $('.codeCon').mouseover(function(){
    $(this).show();    
  }).mouseout(function(){
    $(this).hide();   
  });
  $('.phonedown').hover(function(){
    $(this).siblings('.phonedowCon').show();     
	$(this).parents('.downsubconShow').css("z-index","1");
	$(this).parents('.downsubconShow').siblings().css('z-index','0');
  },function(){
    $(this).siblings('.phonedowCon').hide();     
  });
  $('.phonedowCon').mouseover(function(){
    $(this).show();    
  }).mouseout(function(){
    $(this).hide();   
  });
})
//展开收起