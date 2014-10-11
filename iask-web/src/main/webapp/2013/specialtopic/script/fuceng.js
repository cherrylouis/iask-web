// JavaScript Document
$(function(){
$(window).scroll(function(){
	var scrollTop = $(document).scrollTop();
	var headheight = 396;
	if(scrollTop >= headheight){
		$(".contentR").addClass("fixed");
		}else{
		$(".contentR").removeClass("fixed");	
	}
})
})