<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="../css/jquery.autocomplete.css"/>
</head>
<body>
<div>  
<b>游戏搜索</b>  
<select id="gameType">
<option>刀塔传奇</option>
</select>
<input type="text" id="quick_search" name="q" value=""  />  
<input type="button" value="搜索" class="btn" />  
</div>
<script src="2013/specialtopic/script/jquery1.3.2.js"></script>
<script src="js/jquery.autocomplete.min.js"></script>
<script type="text/livescript">
	$("#quick_search").change(function(){
		var keyword = $("#quick_search").val();
		var gamename = $("#gameType").val();
		var url = "getKeyWords?name="+gamename+"&keyword="+keyword;
	    
	    $("#quick_search").autocomplete(url,{minChars:0}).result(function(event,data,formatted){
	        alert(data);
	    });
	});
</script> 
</body>
</html>