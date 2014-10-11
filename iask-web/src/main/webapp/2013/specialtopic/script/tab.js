// JavaScript Document
$(function(){
  function tabs(tabTit,on,tabCon){
   $(tabCon).each(function(){
      $(this).children().eq(0).show();
   });
   $(tabTit).each(function(){
     $(this).children().eq(0).addClass(on);
   });
   $(tabTit).children().mouseover(function(){
     $(this).addClass(on).siblings().removeClass(on);
     var index = $(tabTit).children().index(this);
     $(tabCon).children().eq(index).show().siblings().hide();
    });
  }
  tabs(".newsTitle","hover",".newsCon");
  tabs(".herotab","hover",".heroCon");
  tabs(".gamespictab","hover",".gamespictabCon");
});