<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>





<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="keywords" content="" />
<meta http-equiv="description" content="" />
<title>刀塔传奇首页</title>
<link rel="stylesheet" href="2013/global/style/global.css" />
<link rel="stylesheet" href="2013/specialtopic/style/spGlobal.css" />
<link rel="stylesheet" href="2013/specialtopic/style/index.css" />
<!--[if IE 6]>
<script src="2013/specialtopic/script/DD_belatedPNG.js"></script>
<script type="text/javascript">
DD_belatedPNG.fix('.gift a,#gotop,.nav,.nav li a.hover,.nav li a:hover,.search input,.videoCon a span');
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
					<li class="first"><a href="index.html" title="官网首页"
						class="hover"></a></li>
					<li><a href="newslist.html" title="综合资讯"></a></li>
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
			<div class="logo">
				<h1>
					<a href="index.html" target="_blank" title="刀塔传奇LOGO"></a>
				</h1>
			</div>
			<div class="search">
				<form name="search">
					<input type="text" value="请输入关键字搜索" maxlength="17" class="txt" /><input
						type="button" class="btn" />
				</form>
			</div>
			<div class="fl news">
				<ul class="newsTitle">
					<li class="hover">综合</li>
					<li>动态</li>
					<li>攻略</li>
					<li>评测</li>
					<li>活动</li>
					<li>问答</li>
				</ul>
				<div class="newsCon">
					<div class="newsSubcon" style="display: block">
						<ul>
							<li><div>
									<a href="#" target="_blank">【综合】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【综合】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【综合】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【综合】《神曲》游戏当乐内测震撼游戏当乐内测震撼开启开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【综合】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【综合】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【综合】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
						</ul>
						<a href="searchMoreQuestion.do" target="_blank" class="newsMore">更多&gt&gt</a>
					</div>
					<div class="newsSubcon">
						<ul>
							<li><div>
									<a href="#" target="_blank">【动态】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【动态】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【动态】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【动态】《神曲》游戏当乐内测震撼游戏当乐内测震撼开启开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【动态】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【动态】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【动态】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
						</ul>
						<a href="#" target="_blank" class="newsMore">更多&gt&gt</a>
					</div>
					<div class="newsSubcon">
						<ul>
							<li><div>
									<a href="#" target="_blank">【攻略】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【攻略】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【攻略】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【攻略】《神曲》游戏当乐内测震撼游戏当乐内测震撼开启开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【攻略】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【攻略】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【攻略】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
						</ul>
						<a href="#" target="_blank" class="newsMore">更多&gt&gt</a>
					</div>
					<div class="newsSubcon">
						<ul>
							<li><div>
									<a href="#" target="_blank">【评测】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【评测】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【评测】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【评测】《神曲》游戏当乐内测震撼游戏当乐内测震撼开启开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【评测】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【评测】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【评测】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
						</ul>
						<a href="#" target="_blank" class="newsMore">更多&gt&gt</a>
					</div>
					<div class="newsSubcon">
						<ul>
							<li><div>
									<a href="#" target="_blank">【活动】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【活动】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【活动】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【活动】《神曲》游戏当乐内测震撼游戏当乐内测震撼开启开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【活动】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【活动】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
							<li><div>
									<a href="#" target="_blank">【活动】《神曲》游戏当乐内测震撼开启</a>
								</div> <span>02-17</span></li>
						</ul>
						<a href="#" target="_blank" class="newsMore">更多&gt&gt</a>
					</div>
					<div class="newsSubcon">

						<ul id="ItemqList">



							<!--  
							<c:forEach var="list" items="${qList}">

								<li><div>
										<a href="qa.do?qid=${list.questions_qid}" target="_blank">${list.qtitle}</a>
									</div> <span>${list.qcreatetime}</span></li>

							</c:forEach>
							-->
						</ul>


						<a href="searchMoreQuestion.do" target="_blank" class="newsMore">更多&gt&gt</a>
					</div>
				</div>
			</div>
			<div class="fl downTextbtn">
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
				<dl class="downText">
					<dd>
						游戏类型：<span>策略</span><span>养成</span><span>卡牌</span>
					</dd>
					<dd>
						支持平台：<span>安卓</span><span>苹果</span>
					</dd>
					<dd>
						游戏状态：<span>公测</span>
					</dd>
					<dd>游戏简介：好玩Q爆萌翻天的世界杯来啦！全球最具价值球员全部在这里，游戏中包含足球名将培养，策略布阵，PVP、PVE，多玩法的世界杯让你乐不停哦~，各种经典赛事，各种传奇你逐一各种传奇你逐各种传奇你逐各种传奇你逐挑~~你准备好了么！
					</dd>
				</dl>
			</div>
			<div class="fl margT module">
				<div class="title heroTitle">
					<h2>
						<i>英</i>英雄图鉴
					</h2>
					<ul class="herotab">
						<li class="hover">全部</li>
						<li>力量</li>
						<li>敏捷</li>
						<li>智力</li>
					</ul>
					<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
				</div>
				<div class="heroCon">
					<div class="heroSubcon" style="display: block">
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默沉默沉默沉默" /><br />沉默沉默沉默沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
					</div>
					<div class="heroSubcon">
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默沉默沉默沉默" /><br />沉默沉默沉默沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士术士术士" /><br />术士术士术士</a>
					</div>
					<div class="heroSubcon">
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
					</div>
					<div class="heroSubcon">
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默沉默沉默沉默" /><br />沉默沉默沉默沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士术士术士术士" /><br />术士术士术士术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
					</div>
				</div>
			</div>
			<div class="fl margT module">
				<div class="fl newsintro">
					<div class="title newsintroTitle">
						<h2>
							<i>新</i>新手入门
						</h2>
						<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
					</div>
					<ul class="newsintroCon">
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
					</ul>
				</div>
				<div class="fl newsintro">
					<div class="title newsintroTitle newsintroTitle2">
						<h2>
							<i>荐</i>阵容推荐
						</h2>
						<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
					</div>
					<ul class="newsintroCon newsintroCon2">
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛女王苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
					</ul>
				</div>
				<div class="fl newsintro newsintro3">
					<div class="title newsintroTitle newsintroTitle3">
						<h2>
							<i>比</i>英雄对比
						</h2>
						<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
					</div>
					<ul class="newsintroCon newsintroCon2">
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛女王苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
					</ul>
				</div>
			</div>
			<div class="fl margT module">
				<div class="title heroTitle">
					<h2>
						<i>备</i>装备图鉴
					</h2>
					<ul class="herotab">
						<li class="hover">全部</li>
						<li>紫装</li>
						<li>蓝装</li>
						<li>绿装</li>
						<li>白装</li>
					</ul>
					<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
				</div>
				<div class="heroCon">
					<div class="heroSubcon" style="display: block">
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默沉默沉默沉默" /><br />沉默沉默沉默沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
					</div>
					<div class="heroSubcon">
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默沉默沉默沉默" /><br />沉默沉默沉默沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士术士术士" /><br />术士术士术士</a>
					</div>
					<div class="heroSubcon">
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
					</div>
					<div class="heroSubcon">
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默沉默沉默沉默" /><br />沉默沉默沉默沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士术士术士术士" /><br />术士术士术士术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
					</div>
					<div class="heroSubcon">
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士术士术士术士" /><br />术士术士术士术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img01.jpg" alt="沉默" /><br />沉默</a>
						<a href="#" target="_blank"><img
							src="2013/specialtopic/images/example/img02.jpg" alt="术士" /><br />术士</a>
					</div>
				</div>
			</div>
			<div class="fl margT module">
				<div class="fl newsintro">
					<div class="title newsintroTitle">
						<h2>
							<i>析</i>英雄分析
						</h2>
						<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
					</div>
					<ul class="newsintroCon">
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
					</ul>
				</div>
				<div class="fl newsintro">
					<div class="title newsintroTitle newsintroTitle2">
						<h2>
							<i>疑</i>小编答疑
						</h2>
						<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
					</div>
					<ul class="newsintroCon newsintroCon2">
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛女王苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
					</ul>
				</div>
				<div class="fl newsintro newsintro3">
					<div class="title newsintroTitle newsintroTitle3">
						<h2>
							<i>攻</i>综合攻略
						</h2>
						<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
					</div>
					<ul class="newsintroCon newsintroCon2">
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛女王苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
						<li><a href="#" target="_blank">刀塔传奇综合症</a></li>
						<li><a href="#" target="_blank">风行和痛苦女王分析</a></li>
					</ul>
				</div>
			</div>
			<div class="fl margT module">
				<div class="fl newsintro">
					<div class="title newsintroTitle">
						<h2>
							<i>视</i>精彩视频
						</h2>
						<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
					</div>
					<div class="newsintroCon videoCon">
						<a href="#" target="_blank"><span></span><img
							src="2013/specialtopic/images/example/img03.jpg" alt="精彩视频" /></a>
					</div>
				</div>
				<div class="fl newsintro">
					<div class="title newsintroTitle newsintroTitle2">
						<h2>
							<i>贴</i>论坛热帖
						</h2>
						<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
					</div>
					<ul class="newsintroCon2 bbshotCon">
						<li><div>
								<a href="#" target="_blank">游戏当乐内测震撼开启</a>
							</div> <span>02-17</span></li>
						<li><div>
								<a href="#" target="_blank">游戏当乐内测震撼开启</a>
							</div> <span>02-17</span></li>
						<li><div>
								<a href="#" target="_blank">游戏当乐内测震撼开启</a>
							</div> <span>02-17</span></li>
						<li><div>
								<a href="#" target="_blank">游戏当乐内测震撼游戏当乐内测震撼开启开启</a>
							</div> <span>02-17</span></li>
						<li><div>
								<a href="#" target="_blank">游戏当乐内测震撼开启</a>
							</div> <span>02-17</span></li>
						<li><div>
								<a href="#" target="_blank">游戏当乐内测震撼开启</a>
							</div> <span>02-17</span></li>
						<li><div>
								<a href="#" target="_blank">游戏当乐内测震撼开启</a>
							</div> <span>02-17</span></li>
						<li><div>
								<a href="#" target="_blank">游戏当乐内测震撼开启</a>
							</div> <span>02-17</span></li>
					</ul>
				</div>
				<div class="fl newsintro newsintro3">
					<div class="title newsintroTitle newsintroTitle3">
						<h2>
							<i>图</i>游戏美图
						</h2>
						<a href="#" target="_blank" class="more">更多&gt;&gt;</a>
					</div>
					<div class="newsintroCon2 gamespicCon">
						<div class="gamespictab">
							<span class="hover">原画</span> <span>截图</span> <span>壁纸</span>
						</div>
						<div class="gamespictabCon">
							<div class="gamespicSubcon" style="display: block">
								<span class="prev">上一页</span> <span class="next">下一页</span>
								<div class="gamespicSubconA">
									<div class="gamespicSubconS">
										<ul>
											<li><a href="#" target="_blank"><img
													src="2013/specialtopic/images/example/img04.jpg" alt="游戏美图" /></a></li>
											<li><a href="#" target="_blank"><img
													src="2013/specialtopic/images/example/img01.jpg" alt="游戏美图" /></a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="gamespicSubcon">
								<span class="prev">上一页</span> <span class="next">下一页</span>
								<div class="gamespicSubconA">
									<div class="gamespicSubconS">
										<ul>
											<li><a href="#" target="_blank"><img
													src="2013/specialtopic/images/example/img02.jpg" alt="游戏美图" /></a></li>
											<li><a href="#" target="_blank"><img
													src="2013/specialtopic/images/example/img04.jpg" alt="游戏美图" /></a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="gamespicSubcon">
								<span class="prev">上一页</span> <span class="next">下一页</span>
								<div class="gamespicSubconA">
									<div class="gamespicSubconS">
										<ul>
											<li><a href="#" target="_blank"><img
													src="2013/specialtopic/images/example/img03.jpg" alt="游戏美图" /></a></li>
											<li><a href="#" target="_blank"><img
													src="2013/specialtopic/images/example/img04.jpg" alt="游戏美图" /></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="fl margT module">
				<div class="fl comment">
					<div class="title commentTitle">
						<h2>
							<i>评</i>评论<span>(已有<strong>50</strong>人发表评论)
							</span>
						</h2>
						<a onclick="showComment()">发表评论</a>
					</div>
					<div class="commentSub">
						<div id="scrollDiv">
							<ul class="commentCon">
								<li><span class="username">【<a href="#"
										target="_blank">用户用用户用户名用用户用户名用户名用</a>】说：
								</span>你是不是刷过机，我下载的要谷歌账我下载的要谷歌账户我下载户我下载</li>
								<li><span class="username">【<a href="#"
										target="_blank">小品子</a>】说：
								</span>你是不是的要谷歌账户我下载的要谷歌账户我下载</li>
								<li><span class="username">【<a href="#"
										target="_blank">56236365</a>】说：
								</span>你是不是刷过机，我下载的要谷歌账户我下载的要谷歌账户我下载</li>
								<li><span class="username">【<a href="#"
										target="_blank">&鸡飞蛋打</a>】说：
								</span>谷歌账户我下载的要谷歌账户我下载</li>
								<li><span class="username">【<a href="#"
										target="_blank">用户用户名用</a>】说：
								</span>你是不是刷过机，我下载的要要谷歌账</li>
								<li><span class="username">【<a href="#"
										target="_blank">小品子</a>】说：
								</span>你是不是的要谷歌账户我下载的要谷歌账户我下载</li>
								<li><span class="username">【<a href="#"
										target="_blank">56236365</a>】说：
								</span>你是不是刷户我下载</li>
								<li><span class="username">【<a href="#"
										target="_blank">&鸡飞蛋打</a>】说：
								</span>谷歌账户我下载的要谷歌账户我下载</li>
								<li><span class="username">【<a href="#"
										target="_blank">56236365</a>】说：
								</span>你是不是刷过机，我下载的要谷歌账户我下载的要谷歌账户我下载</li>
							</ul>
						</div>
						<div class="commentMore">
							<a href="#" target="_blank">更多&gt;&gt;</a>
						</div>
					</div>
				</div>
				<div class="fl gamesinfo">
					<div class="title commentTitle gamesinfoTitle">
						<h2>
							<i>游</i>游戏信息
						</h2>
					</div>
					<div class="commentSub newsintroCon2">
						<dl class="gamesinfoCon">
							<dd>
								<em>游戏名称：</em>刀塔传奇
							</dd>
							<dd>
								<em>游戏类型：</em><span>即时</span><span>3D</span><span>武侠</span>
							</dd>
							<dd>
								<em>游戏平台：</em><span>安卓</span><span>苹果</span>
							</dd>
							<dd>
								<em>支持状态：</em><span>公测</span>
							</dd>
							<dd>
								<em>客服电话:</em>4000860066
							</dd>
							<dd>
								<em>玩家交流1群:</em>373296258
							</dd>
							<dd>
								<em>玩家交流2群:</em>175468078（1000人大群）
							</dd>
							<dd>
								<em>玩家交流1群:</em>373296258
							</dd>
							<dd>
								<em>玩家交流2群:</em>175468078（1000人大群）
							</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="fl margT module">
				<div class="title heroTitle">
					<h2>
						<i>荐</i>推荐游戏
					</h2>
				</div>
				<div class="linksCon">
					<a href="#" target="_blank">神雕侠侣</a>|<a href="#" target="_blank">梦想海贼王</a>|<a
						href="#" target="_blank">神魔大陆</a>|<a href="#" target="_blank">神鬼幻想</a>|<a
						href="#" target="_blank">伊甸</a>|<a href="#" target="_blank">混沌与秩序之英雄战歌</a>|<a
						href="#" target="_blank">神魔大陆</a>|<a href="#" target="_blank">混沌与秩序之英雄战歌</a>|<a
						href="#" target="_blank">伊甸</a>|<a href="#" target="_blank">神雕侠侣</a>|<a
						href="#" target="_blank">梦想海贼王</a>|<a href="#" target="_blank">神魔大陆</a>|<a
						href="#" target="_blank">神鬼幻想</a>|<a href="#" target="_blank">伊甸</a>|<a
						href="#" target="_blank">混沌与秩序之英雄战歌</a>|<a href="#"
						target="_blank">神魔大陆</a>|<a href="#" target="_blank">混沌与秩序之英雄战歌</a>|<a
						href="#" target="_blank">伊甸</a>
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
	<!--gift and go top begin-->
	<div class="gift">
		<a href="#"><span></span></a>
	</div>
	<div id="tbox">
		<a id="gotop" href="javascript:void(0)"></a>
	</div>
	<!--gift and go top end-->
	<!--comment begin-->
	<div id="fullbg"></div>
	<div class="commentShow" id="commentShow">
		<a onclick="closeDiv()" class="closediv"></a>
		<h2>评论</h2>
		<form>
			<textarea name="textarea" class="commentArea">输入评论...</textarea>
			<div class="commentLRBtn">
				验证码：<input type="text" class="yzmcode" /><img
					src="2013/specialtopic/images/example/yzcodebg.png" alt="验证码" /><a
					href="#">看不清</a><input type="button" value="发表评论" class="btn" />
			</div>
		</form>
	</div>
	<!--comment end-->
	<script src="2013/specialtopic/script/jquery1.3.2.js"></script>
	<script src="2013/specialtopic/script/toTop.js"></script>
	<script src="2013/specialtopic/script/showcode.js"></script>
	<script src="2013/specialtopic/script/tab.js"></script>
	<script src="2013/specialtopic/script/scrollup.js"></script>
	<script src="2013/specialtopic/script/imgleftright.js"></script>
	<script>
		//显示灰色 jQuery 遮罩层
		function full() {
			var bh = document.body.clientHeight;
			var bw = document.body.clientWidth;
			$("#fullbg").css({
				height : bh,
				width : bw,
				display : "block"
			});
		}
		function showComment() {
			full();
			$("#commentShow").show();
		}
		//关闭灰色 jQuery 遮罩
		function closeDiv() {
			$("#fullbg,#commentShow").hide();
		}
	</script>
	<script type="text/livescript">
		
	
		
		
		
		
    // 将日期转换为时间戳
	function strtotime(strings){ 

	    var arr = strings.split(" "); 

	    var arr1 = arr[0].split("-"); 

	    var arr2 = arr[1].split(":"); 

	    var year = arr1[0]; 

	    var month = arr1[1]-1; 

	    var day = arr1[2]; 

	    var hour = arr2[0]; 

	    var mon = arr2[1]; 

	    var timestamp = new Date(year,month,day,hour,mon).getTime()/1000;  

	    return timestamp; 

	}	
		
	// 将时间戳转换为日期
	function date(format, timestamp){ 
	    var a, jsdate=((timestamp) ? new Date(timestamp*1000) : new Date());
	    var pad = function(n, c){
	        if((n = n + "").length < c){
	            return new Array(++c - n.length).join("0") + n;
	        } else {
	            return n;
	        }
	    };
	    var txt_weekdays = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
	    var txt_ordin = {1:"st", 2:"nd", 3:"rd", 21:"st", 22:"nd", 23:"rd", 31:"st"};
	    var txt_months = ["", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]; 
	    var f = {
	        // Day
	        d: function(){return pad(f.j(), 2)},
	        D: function(){return f.l().substr(0,3)},
	        j: function(){return jsdate.getDate()},
	        l: function(){return txt_weekdays[f.w()]},
	        N: function(){return f.w() + 1},
	        S: function(){return txt_ordin[f.j()] ? txt_ordin[f.j()] : 'th'},
	        w: function(){return jsdate.getDay()},
	        z: function(){return (jsdate - new Date(jsdate.getFullYear() + "/1/1")) / 864e5 >> 0},
	      
	        // Week
	        W: function(){
	            var a = f.z(), b = 364 + f.L() - a;
	            var nd2, nd = (new Date(jsdate.getFullYear() + "/1/1").getDay() || 7) - 1;
	            if(b <= 2 && ((jsdate.getDay() || 7) - 1) <= 2 - b){
	                return 1;
	            } else{
	                if(a <= 2 && nd >= 4 && a >= (6 - nd)){
	                    nd2 = new Date(jsdate.getFullYear() - 1 + "/12/31");
	                    return date("W", Math.round(nd2.getTime()/1000));
	                } else{
	                    return (1 + (nd <= 3 ? ((a + nd) / 7) : (a - (7 - nd)) / 7) >> 0);
	                }
	            }
	        },
	      
	        // Month
	        F: function(){return txt_months[f.n()]},
	        m: function(){return pad(f.n(), 2)},
	        M: function(){return f.F().substr(0,3)},
	        n: function(){return jsdate.getMonth() + 1},
	        t: function(){
	            var n;
	            if( (n = jsdate.getMonth() + 1) == 2 ){
	                return 28 + f.L();
	            } else{
	                if( n & 1 && n < 8 || !(n & 1) && n > 7 ){
	                    return 31;
	                } else{
	                    return 30;
	                }
	            }
	        },
	      
	        // Year
	        L: function(){var y = f.Y();return (!(y & 3) && (y % 1e2 || !(y % 4e2))) ? 1 : 0},
	        //o not supported yet
	        Y: function(){return jsdate.getFullYear()},
	        y: function(){return (jsdate.getFullYear() + "").slice(2)},
	      
	        // Time
	        a: function(){return jsdate.getHours() > 11 ? "pm" : "am"},
	        A: function(){return f.a().toUpperCase()},
	        B: function(){
	            // peter paul koch:
	            var off = (jsdate.getTimezoneOffset() + 60)*60;
	            var theSeconds = (jsdate.getHours() * 3600) + (jsdate.getMinutes() * 60) + jsdate.getSeconds() + off;
	            var beat = Math.floor(theSeconds/86.4);
	            if (beat > 1000) beat -= 1000;
	            if (beat < 0) beat += 1000;
	            if ((String(beat)).length == 1) beat = "00"+beat;
	            if ((String(beat)).length == 2) beat = "0"+beat;
	            return beat;
	        },
	        g: function(){return jsdate.getHours() % 12 || 12},
	        G: function(){return jsdate.getHours()},
	        h: function(){return pad(f.g(), 2)},
	        H: function(){return pad(jsdate.getHours(), 2)},
	        i: function(){return pad(jsdate.getMinutes(), 2)},
	        s: function(){return pad(jsdate.getSeconds(), 2)},
	        //u not supported yet
	      
	        // Timezone
	        //e not supported yet
	        //I not supported yet
	        O: function(){
	            var t = pad(Math.abs(jsdate.getTimezoneOffset()/60*100), 4);
	            if (jsdate.getTimezoneOffset() > 0) t = "-" + t; else t = "+" + t;
	            return t;
	        },
	        P: function(){var O = f.O();return (O.substr(0, 3) + ":" + O.substr(3, 2))},
	        //T not supported yet
	        //Z not supported yet
	      
	        // Full Date/Time
	        c: function(){return f.Y() + "-" + f.m() + "-" + f.d() + "T" + f.h() + ":" + f.i() + ":" + f.s() + f.P()},
	        //r not supported yet
	        U: function(){return Math.round(jsdate.getTime()/1000)}
	    };
	      
	    return format.replace(/[\\]?([a-zA-Z])/g, function(t, s){
	        if( t!=s ){
	            // escaped
	            ret = s;
	        } else if( f[s] ){
	            // a date function exists
	            ret = f[s]();
	        } else{
	            // nothing special
	            ret = s;
	        }
	        return ret;
	    });
	}



		
		
$(function(){　　
	

	
	var logCode=$(".txt");
	var commentArea=$(".commentArea");
	logCode.val("请输入关键字搜索");
	logCode.blur();
	commentArea.val("输入评论...");
	commentArea.blur();
    logCode.bind("focus",function(){
		var t=$(this).val();
		if(t=="请输入关键字搜索"){$(this).val("");$(this).css("color","#333")}
		})
    logCode.bind("blur",function(){
		if($(this).val().replace(/[ ]/g,"")==""){
			$(this).val("请输入关键字搜索").css("color","#8e8e8e");
			}
		})
	commentArea.bind("focus",function(){
		var t=$(this).val();
		if(t=="输入评论..."){$(this).val("");$(this).css("color","#333")}
		})
    commentArea.bind("blur",function(){
		if($(this).val().replace(/[ ]/g,"")==""){
			$(this).val("输入评论...").css("color","#8e8e8e");
			}
		})
		
	    
       var qList=$("#ItemqList");
	       $.ajax({
               type: "GET",   //访问WebService使用Post方式请求
               contentType: "application/json", 
               dataType:"json",
               url: "searchTitleList?currentPage=1&pageSize=7&gameId=1", 
               success: function(data) {     
              	   for(var i=0;i<data.length;i++)
                   {
              		 var divtext=$("<li><div> <a href=searchAnswer?questionId="+data[i].id+" target=_blank>"+data[i].qtitle+"</a> </div> <span>"+date("m-d",strtotime(data[i].qcreatime))+"</span></div></li>");  // 以 jQuery 创建新元素
              		qList.append(divtext);
                    }
               }
           });
		
});

	
	
	
	
	
	
	
	
	
	
	
	</script>

	<!-- 
	
	
	
	 -->

</body>
</html>
