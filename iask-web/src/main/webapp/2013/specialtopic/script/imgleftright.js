// JavaScript Document
$(function(){
var page=1;
var i=1;
$('span.next').click(function(){
  var $parent=$(this).parents('.gamespicSubcon');
  var $vShow=$parent.find('.gamespicSubconS');
  var $vContent=$parent.find('.gamespicSubconA');
  var $vWidth=$vContent.width();
  var len=$vShow.find('li').length;
  var pageCount=Math.ceil(len/i);
  if(!$vShow.is(":animated")){
	if(page==pageCount){
      $vShow.animate({left:'0px'},500);
	  page=1;
    }else{
	  $vShow.animate({left:'-='+$vWidth},500);
	  page++;
	}
  }
});
$('span.prev').click(function(){
  var $parent=$(this).parents('.gamespicSubcon');
  var $vShow=$parent.find('.gamespicSubconS');
  var $vContent=$parent.find('.gamespicSubconA');
  var $vWidth=$vContent.width();
  var len=$vShow.find('li').length;
  var pageCount=Math.ceil(len/i);
  if(!$vShow.is(':animated')){
    if(page==1){
	  $vShow.animate({left:'-='+($vWidth*(pageCount-1))},500);
	  page=pageCount;
	}else{
	  $vShow.animate({left:'+='+$vWidth},500);
	  page--;
	}
  }
});
})