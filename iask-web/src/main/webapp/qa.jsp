
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<title>刀塔传奇问答详情页</title>
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
					<li><a href="newslist.html" title="综合资讯" class="hover"></a></li>
					<li><a href="maoflistHero.html" title="英雄图鉴"></a></li>
					<li><a href="maoflistEquip.html" title="装备图鉴"></a></li>
					<li><a href="newslistStrategy.html" title="游戏攻略"></a></li>
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
							<i>综</i><a href="newslist.html">综合资讯</a><span>&gt;</span>问答详情
						</h2>
						<a href="index.html" target="_blank" class="more">返回首页&gt;&gt;</a>
					</div>
					<div class="listCon QA">
						<div class="question clearfix">
							<i>问</i>
							<div class="fr Qcontent">
								<h3>${question.title}</h3>
								<p>${question.description}</p>
								<div class="Qtime">
									<span>${question.username}</span> <span>浏览${question.pv}次</span> <span
										class="time">${question.createtime}</span>
								</div>
							</div>
						</div>
						<div class="answer clearfix">

							<c:if test="${!empty best}">
								<i>答</i>
								<div class="fr Qcontent Acontent">
									<div class="bestAnswerBor">
										<div class="bestAnswer">
											<h5 class="Atitle">最佳答案</h5>
											<p>${best.context}</p>
											<div class="Qtime">
												<span>${best.username}</span> <span class="time">${best.createtime}</span>
											</div>
										</div>
									</div>
							</c:if>

							<div class="qtAnswer">


								<div class="qtAtitle">
									<i></i>
									<h5 class="Atitle">其他答案</h5>
									<span>共${fn:length(answers)}条</span>
								</div>

								<dl id="acontent_list_five">


									<c:forEach var="list" items="${answers}" varStatus="status">
										<c:if test="${status.index<5}">
											<dd id="alist${status.index}">
												<p>${list.context}</p>
												<div class="Qtime">
													<span>${list.username}</span> <span class="time">${list.createtime}</span>
												</div>
											</dd>
										</c:if>

									</c:forEach>



									<c:if test="${fn:length(answers)>5}">
										<dd class="moreA">
											<a href="javascript:void(0)" id="more_answers">更多答案&gt&gt</a>
										</dd>
									</c:if>

								</dl>


								<dl id="acontent_list_all" style="display: none">


									<c:forEach var="list" items="${answers}" varStatus="status">
										<dd id="alist${status.count}">
											<p>${list.context}</p>
											<div class="Qtime">
												<span>${list.username}</span> <span class="time">${list.createtime}</span>
											</div>
										</dd>
									</c:forEach>

								</dl>





							</div>
							<div class="similarQuestion">
								<h5 class="Atitle">类似问题</h5>



								<ul id="list_five">


									<c:forEach var="list" items="${mlt}" begin="0" end="4">

										<li>
											<div>
												<a href="searchAnswer.do?questionId=${list.id}" target="_blank">${list.title}</a>
											</div> <span>${list.createtime}</span>
										</li>
									</c:forEach>



									<li class="moreQ"><a href="javascript:void(0)"
										id="more_question" target="_blank">查看更多相关问题&gt;&gt;</a></li>
								</ul>

								<ul id="list_all">

									
									<c:forEach var="list" items="${mlt}">

										<li>
											<div>
												<a
													href="searchAnswer.do?questionId=${list.id}"
													target="_blank">${list.title}</a>
											</div> <span>${list.createtime}</span>
										</li>
									</c:forEach>

								</ul>



							</div>
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
			
			
			var acontent_list_five=$("#acontent_list_five");
	    var acontent_list_all =$("#acontent_list_all");
	    acontent_list_all.hide();
	    
	    var more_answer=$("#more_answers");
	    more_answer.click(function(){
	    	acontent_list_five.hide();
	    	acontent_list_all.show();
	    });
	    
	    var list_five=$("#list_five");
	    var list_all=$("#list_all");
	    list_all.hide();
	   
	   var more_question=$("#more_question");
	   more_question.click(function(){
		   list_five.hide();
		   list_all.show();
	   });
	});
	
	</script>
</body>
</html>