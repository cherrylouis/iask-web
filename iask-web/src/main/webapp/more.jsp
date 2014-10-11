<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="" />
<meta http-equiv="description" content="" />
<title>刀塔传奇资讯列表页实用攻略</title>
<link rel="stylesheet" href="2013/global/style/global.css" />
<link rel="stylesheet" href="2013/specialtopic/style/spGlobal.css" />
<link rel="stylesheet" href="2013/specialtopic/style/common.css" />
<link rel="stylesheet" href="2013/specialtopic/style/news.css" />
<!--[if IE 6]>
<script src="2013/specialtopic/script/DD_belatedPNG.js"></script>
<script type="text/javascript">
DD_belatedPNG.fix('.gift a,#gotop,.nav,.nav li a.hover,.nav li a:hover,.search input,.downloadSubon a, .downloadSubon span');
</script>
<![endif]-->
</head>

<body>
	<!--当乐首页顶部导航begin-->
	<div id="siteNav" class="clearfix">
		<div class="layout clearfix">
			<div class="fl">
				<a href="http://www.d.cn/" target="_blank" class="rb"><strong>当乐首页</strong></a><span><a
					href="http://my.d.cn/" target="_blank" class="login">登录当乐</a><a
					href="http://my.d.cn/register.html" target="_blank" class="reg">免费注册</a></span>
			</div>
			<div class="fr">
				<a href="http://android.d.cn" target="_blank" title="当乐网安卓游戏门户">安卓</a><a
					href="http://ios.d.cn" target="_blank" title="当乐网苹果游戏门户">苹果</a><a
					href="http://wp.d.cn" title="当乐网WP游戏门户" target="_blank">WP</a><a
					href="http://www.d.cn/symbian.html" title="当乐网塞班Java游戏门户"
					target="_blank">塞班</a><a href="http://ng.d.cn/" title="当乐网手机网游"
					target="_blank">网游</a><a href="http://news.d.cn/" title="当乐网游戏新闻"
					target="_blank">新闻</a><a href="http://bbs.d.cn/" title="当乐网玩家社区"
					target="_blank" class="rb">社区</a><a
					href="http://www.d.cn/mobile.html" title="手机上当乐" target="_blank"
					class="mobV">手机版</a>
			</div>
		</div>
	</div>
	<!--登录后-->
	<!--<div id="siteNav" class="clearfix">
  <div class="layout">
    <div class="fl"><a href="http://www.d.cn/" target="_blank" class="rb"><strong>当乐首页</strong></a><span>&nbsp;&nbsp;&nbsp;您好，<a class="nickName" href="http://my.d.cn/" target="_blank">用户昵称</a> <a href="http://my.d.cn/mymsg.html" target="_blank" class="rb">新消息(<em>10</em>)</a><a href="javascript:void(0);">安全退出</a></span></div>
    <div class="fr"><a href="http://android.d.cn" target="_blank" title="当乐网安卓游戏门户">安卓</a><a href="http://ios.d.cn" target="_blank" title="当乐网苹果游戏门户">苹果</a><a href="http://wp.d.cn" title="当乐网WP游戏门户" target="_blank">WP</a><a href="http://www.d.cn/symbian.html" title="当乐网塞班Java游戏门户" target="_blank">塞班</a><a href="http://ng.d.cn/" title="当乐网手机网游" target="_blank">网游</a><a href="http://news.d.cn/" title="当乐网游戏新闻" target="_blank">新闻</a><a href="http://bbs.d.cn/" title="当乐网玩家社区" target="_blank" class="rb">社区</a><a href="http://www.d.cn/mobile.html" title="手机上当乐" target="_blank" class="mobV">手机版</a></div>
  </div>
</div><!--当乐首页顶部导航end-->
	<div class="container">
		<div class="main layout clearfix">
			<div class="navbor">
				<ul class="nav">
					<li class="first"><a href="index.html" title="官网首页"></a></li>
					<li><a href="newslist.html" title="综合资讯"></a></li>
					<li><a href="maoflistHero.html" title="英雄图鉴"></a></li>
					<li><a href="maoflistEquip.html" title="装备图鉴"></a></li>
					<li><a href="newslistStrategy.html" title="游戏攻略" class="hover"></a></li>
					<li><a href="#" title="资料大全"></a></li>
					<li><a href="download.html" title="下载中心"></a></li>
					<li><a href="piclist.html" title="游戏美图"></a></li>
					<li><a href="videolist.html" title="精彩视频"></a></li>
					<li class="last"><a href="http://bbs.d.cn" title="玩家论坛"></a></li>
				</ul>
			</div>
			<div class="logoDown">
				<h1>
					<a href="index.html" target="_blank" title="刀塔传奇LOGO"></a>
				</h1>
				<div class="download">
					<div class="fl downloadSubon androiddown">
						<!--一个下载资源时<a href="#" title="安卓版下载"></a>-->
						<span></span>
						<div class="androidShow">
							<div class="androidShowSub">
								<dl>
									<dd>
										<a href="#">安卓通用版 1.0.12(76MB)<br />更新时间：2013-3-10
										</a>
									</dd>
									<dd>
										<a href="#">安卓通用版 1.0.12(76MB)<br />更新时间：2013-3-10
										</a>
									</dd>
								</dl>
								<div class="androidShowBottom"></div>
							</div>
						</div>
					</div>
					<div class="fl downloadSubon iosdown">
						<!--一个下载资源时<a href="#" title="ios版下载"></a>-->
						<span></span>
						<div class="androidShow">
							<div class="androidShowSub">
								<dl>
									<dd>
										<a href="#">苹果通用版 1.0.12(76MB)<br />更新时间：2013-3-10
										</a>
									</dd>
									<dd>
										<a href="#">苹果通用版 2.0.12(76MB)<br />更新时间：2013-4-13
										</a>
									</dd>
									<dd>
										<a href="#">苹果通用版 3.0.12(76MB)<br />更新时间：2013-5-15
										</a>
									</dd>
								</dl>
								<div class="androidShowBottom"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="search">
				<form name="search">
					<input type="text" value="请输入关键字搜索" maxlength="17" class="txt" /><input
						type="button" class="btn" />
				</form>
			</div>
			<div class="sublistCon">
				<div class="fl contentL">
					<div class="title contentTitle">
						<h2>
							<i>综</i>综合资讯
						</h2>
						<a href="index.html" target="_blank" class="more">返回首页&gt;&gt;</a>
					</div>
					<div class="listCon">
						<div class="detailTab">
							<a href="newslist.html">综合资讯</a><a href="newslist.html">游戏动态</a><a
								href="newslistStrategy.html" class="hover">实用攻略</a><a
								href="newslist.html">活动中心</a><a href="newslist.html">游戏评测</a><a
								href="newslist.html">问答</a>
						</div>
						<div class="strategyTab">
							<a href="newslistStrategy.html" target="_blank" class="hover">所有攻略</a>|<a
								href="newslistStrategy.html" target="_blank">新手入门</a>|<a
								href="newslistStrategy.html" target="_blank">阵容推荐</a>|<a
								href="newslistStrategy.html" target="_blank">英雄对比</a>|<a
								href="newslistStrategy.html" target="_blank">英雄分析</a>|<a
								href="newslistStrategy.html" target="_blank">小编答疑</a>|<a
								href="newslistStrategy.html" target="_blank">综合攻略</a>
						</div>
						<div class="newslist">
							<ul id="newslist" class="clearfix">

								<!--  
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>欢迎来到《魔塔星球》</a>
									</div> <span>2014-05-28</span></li>
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>《猎神OL》新增主城区域详细图文介绍</a>
									</div> <span>2014-05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《天地豪侠OL》灵兽装备炼化永久开放灵兽装备炼化永久开放灵兽装备炼化永久开放</a>
									</div> <span>2014-05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《烈焰之痕》新资料片岩魔重磅启动</a>
									</div> <span>2014-05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《战谷》内测手机连连送获奖名单</a>
									</div> <span>05-28</span></li>
								<li class="newsBorder"></li>
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>欢迎来到《魔塔星球》</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>《猎神OL》新增主城区域详细图文介绍</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《天地豪侠OL》灵兽装备炼化永久开放灵兽装备炼化永久开放灵兽装备炼化永久开放</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《烈焰之痕》新资料片岩魔重磅启动</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《战谷》内测手机连连送获奖名单</a>
									</div> <span>05-28</span></li>
								<li class="newsBorder"></li>
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>欢迎来到《魔塔星球》</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>《猎神OL》新增主城区域详细图文介绍</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《天地豪侠OL》灵兽装备炼化永久开放灵兽装备炼化永久开放灵兽装备炼化永久开放</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《烈焰之痕》新资料片岩魔重磅启动</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《战谷》内测手机连连送获奖名单</a>
									</div> <span>05-28</span></li>
								<li class="newsBorder"></li>
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>欢迎来到《魔塔星球》</a>
									</div> <span>2014-05-28</span></li>
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>《猎神OL》新增主城区域详细图文介绍</a>
									</div> <span>2014-05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《天地豪侠OL》灵兽装备炼化永久开放灵兽装备炼化永久开放灵兽装备炼化永久开放</a>
									</div> <span>2014-05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《烈焰之痕》新资料片岩魔重磅启动</a>
									</div> <span>2014-05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《战谷》内测手机连连送获奖名单</a>
									</div> <span>05-28</span></li>
								<li class="newsBorder"></li>
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>欢迎来到《魔塔星球》</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>《猎神OL》新增主城区域详细图文介绍</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《天地豪侠OL》灵兽装备炼化永久开放灵兽装备炼化永久开放灵兽装备炼化永久开放</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《烈焰之痕》新资料片岩魔重磅启动</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《战谷》内测手机连连送获奖名单</a>
									</div> <span>05-28</span></li>
								<li class="newsBorder"></li>
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>欢迎来到《魔塔星球》</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="newsdetail.html" target="_blank"><em>【新闻】</em>《猎神OL》新增主城区域详细图文介绍</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《天地豪侠OL》灵兽装备炼化永久开放灵兽装备炼化永久开放灵兽装备炼化永久开放</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《烈焰之痕》新资料片岩魔重磅启动</a>
									</div> <span>05-28</span></li>
								<li><div>
										<a href="#" target="_blank"><em>【新闻】</em>《战谷》内测手机连连送获奖名单</a>
									</div> <span>05-28</span></li>
								<li class="newsBorder"></li>
								
								-->

								<c:forEach var="list" items="${qList}" varStatus="status">

									<li><div>
											<a href="qa.do?qid=${list.questions_qid}" target="_blank"><em>【问答】</em>${list.qtitle}</a>
										</div> <span>${list.qcreatetime}</span></li>

									<c:if test="${(status.count%5==0)}">
										<li class="newsBorder"></li>
									</c:if>

								</c:forEach>


								<c:if test="${fn:length(qList)%5!=0}">
									<li class="newsBorder"></li>
								</c:if>



							</ul>
							<div class="pages">


								<c:if test="${currentPage==1}">
									<a href="#">上一页</a>
								</c:if>

								<c:if test="${currentPage>1}">
									<a href="newslistStrategy.do?currentPage=${currentPage}">上一页</a>
								</c:if>

								<c:forEach begin="${beginpage}" end="${endpage}"
									varStatus="status">

									<c:set var="page" value="${status.index}" />

									<c:if test="${currentPage==page}">
										<a href='newslistStrategy.do?currentPage=${currentPage}'
											class='num hover'> <!--  
											${currentPage}
											-->
										</a>
										<c:set var="cp" value="${currentPage}" />
									</c:if>


									<c:if test="${currentPage!=page}">

										<a href='newslistStrategy.do?currentPage=${status.index}'
											class='num'>${status.index}</a>
									</c:if>



								</c:forEach>




								<c:if test="${currentPage==maxPage}">
									<a href="#">下一页</a>
								</c:if>
								<c:if test="${currentPage<maxPage}">
									<a href="newslistStrategy.do?currentPage=${currentPage+1}">下一页</a>
								</c:if>

								<form action="newslistStrategy.do?currentPage=${currentPage}"
									style="display: inline">
									<input type="text" class="pagetxt" id="redirectPagerInputId" /><input
										type="button" value="跳转" class="btn"
										onclick="JavaScript:redirectTopage(document.getElementById('redirectPagerInputId').value);" />
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="fr contentR">
					<div class="title infoTitle">
						<h2>
							<i>攻</i>推荐攻略
						</h2>
						<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
					</div>
					<div class="infoCon">
						<ul>
							<li><a href="#" target="_blank">11月19日不正当游戏行为封号名单为封号</a></li>
							<li><a href="#" target="_blank">11月19日不正当游戏行为封号名单为封号</a></li>
							<li><a href="#" target="_blank">11月19日不正当游戏行为封号名单为封号</a></li>
							<li><a href="#" target="_blank">11月19日不正当游戏行为封号名单为封号</a></li>
							<li><a href="#" target="_blank">11月19日不正当游戏行为封号名单为封号，侠客天赋、缘分。</a></li>
							<li><a href="#" target="_blank">11月19日不正当游戏行为封号名单为封号</a></li>
							<li><a href="#" target="_blank">11月19日不正当游戏行为封号名单为封号</a></li>
							<li><a href="#" target="_blank">11月19日不正当游戏行为封号名单为封号，侠客天赋、缘分。</a></li>
							<li><a href="#" target="_blank">11月19日不正当游戏行为封号名单为封号</a></li>
							<li><a href="#" target="_blank">侠客天赋、缘分、升级介绍</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--footer begin-->
	<div class="footer">
		<p>
			<a href="http://www.d.cn/about_us.html" target="_blank">关于当乐</a> | <a
				href="http://www.d.cn/en-us/" target="_blank">About Downjoy</a> | <a
				href="http://www.d.cn/contact_us.html" target="_blank">联系我们</a> | <a
				href="http://www.d.cn/appsubmit.html" target="_blank">应用提交</a> | <a
				href="http://www.d.cn/hr/" target="_blank">诚聘英才</a> | <a
				href="http://dev.d.cn/" target="_blank">魔兽计划</a> | <a
				href="http://www.d.cn/help.html" target="_blank">帮助中心</a> | <a
				href="http://www.d.cn/privacy.html" target="_blank">隐私保护</a> | <a
				href="http://www.d.cn/sitemap.html" target="_blank">网站地图</a>
		</p>
		<p>
			Copyright © 2004-2013 Downjoy. All Rights Reserved. 当乐公司&nbsp;<a
				href="http://www.d.cn/copyright.html" target="_blank">版权所有</a>
		</p>
	</div>
	<!--footer end-->
	<!--go top begin-->
	<div id="tbox">
		<a id="gotop" href="javascript:void(0)"></a>
	</div>
	<!--go top end-->
	<script src="2013/specialtopic/script/jquery1.3.2.js"></script>
	<script src="2013/specialtopic/script/toTop.js"></script>
	<script src="2013/specialtopic/script/showcode.js"></script>
	<script src="2013/specialtopic/script/fuceng.js"></script>
	<script type="text/livescript">
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	/**
	 *@description redirect to
	 *@param redirect to page number
	 */
	function redirectTopage(toPage){
	  var r = /^\+?[1-9][0-9]*$/;//正整数 
	  if (!r.test(toPage)) {
	    alert("页码输入有误，请输入大于0的整数!");
	    return;
	  }
	  if (toPage > 47) {
	    toPage = 47;
	  }
	  window.location = "newslistStrategy.do?currentPage=" + toPage ;
	}

		
		
$(function(){　　
	var logCode=$(".txt");
	logCode.val("请输入关键字搜索");
	logCode.blur();
    logCode.bind("focus",function(){
		var t=$(this).val();
		if(t=="请输入关键字搜索"){$(this).val("");$(this).css("color","#333")}
		})
    logCode.bind("blur",function(){
		if($(this).val().replace(/[ ]/g,"")==""){
			$(this).val("请输入关键字搜索").css("color","#8e8e8e");
			}
		})
		
		
	       $.ajax({
               type: "POST",  
               contentType: "application/json", 
               dataType:"json",
               url: "searchTitleList.do?currentPage=1&pageSize=20", 
               success: function(data) {    
            	   
            	   var newslist=$("#newslist");
            	   
            	   for(var i=0;i<data.length;i++)
            	  {
            		   if(i%5==0)
            			{
            			   newslist.append($("<li class=newsBorder></li>"));
            			}
            		 
            		   var titleText=$("<li><div><a href=searchAnswer.do?questionId="+data[i].id+" target=_blank><em>【问答】</em>"+data[i].title+"</a> </div> <span>${list.qcreatetime}</span></li>");
            		 
            		   newslist.append(titleText);
            		   
            	  }
            	   
            	   
               }
           });
		
		
});

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</script>
</body>
</html>