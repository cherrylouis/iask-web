<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.downjoy.iask.domain.User"%>
<%@ page import="com.downjoy.iask.util.Constants"%>
<%@ page import="org.directwebremoting.ServerContextFactory"%>
<%@ page import="org.directwebremoting.Container"%>
<%@ page
	import="com.downjoy.push.controller.DwrScriptSessionManagerUtil"%>
<%@ page import="org.directwebremoting.extend.ScriptSessionManager"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    User user = (User) request.getSession().getAttribute(
            Constants.CURRENT_SESSION_USER);
    String userId = (String) request.getSession().getAttribute(
            Constants.CURRENT_USER_ID);

    Container container = ServerContextFactory.get().getContainer();
    ScriptSessionManager manager = container
            .getBean(ScriptSessionManager.class);
    manager.addScriptSessionListener(new DwrScriptSessionManagerUtil());
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'MyJsp.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type='text/javascript' src='<%=basePath%>dwr/engine.js'></script>
<script type='text/javascript' src='<%=basePath%>dwr/util.js'></script>
<script type='text/javascript'
	src='<%=basePath%>dwr/interface/directorController.js'></script>

<script type="text/javascript">
	$(function() {
		//这句话千万不能少 ，表示允许使用推送技术
		dwr.engine.setActiveReverseAjax(true);
		//dwr.engine.setNotifyServerOnPageUnload(true);
		dwr.engine.setErrorHandler(function(){});
		initScriptSession();
	});

	function initScriptSession() {
		
		directorController.message("<%=userId%>");

	}
	function send() {
		var msg = document.getElementById("msgId").value;
		var obj = new Object();
		obj.senderId = msg;
		obj.receiverId = 57;
		obj.context = msg;
		obj.pushType = "3";
		obj.pushUserType="2";
		directorController.sendMessageAuto(obj);
	}
	function showMessage(data) {
		$("#receive").val(data);
	}
</script>
</head>

<body>
	id&nbsp;&nbsp;&nbsp;&nbsp;:
	<input type="text" name="msgId" id="msgId" />
	<br />


	<input type="text" name="receive" id="receive">
	<br />
	<input type="button" value="Send" onclick="send()" />

</body>
</html>
