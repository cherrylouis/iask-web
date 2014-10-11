// 表示当前高亮的节点
var highlightindex = -1;
$(document).ready(function() {

	var search = $("#search-buttonss");
	var inputText = $("#inputss");
	var title = $("#title");
	var content = $("#content");

//	search.click(function() {
//
//		// var searchKey = inputText.val();
//		//
//		// this.load("search.do",{
//		// q:searchKey,
//		// title:title.attr("checked"),
//		// content:content.attr("checked")
//		// });
//
//		var qsData = {
//			'q' : inputText.val(),
//			'title' : title.attr("checked"),
//			'content' : content.attr("checked")
//		};
//
//		$.get("search.do", qsData,function(result){
//			
//		},"text");

		// async : false,
		// url : "search.do",
		// type : "GET",
		// contentType : "application/x-www-form-urlencoded; charset=utf-8",
		// data : qsData,
		// timeout : 10000,
		// beforeSend : function() {
		// // jsonp 方式此方法不被触发.原因可能是dataType如果指定为jsonp的话,就已经不是ajax事件了
		// },
		// success : function(json) {//
		// 客户端jquery预先定义好的callback函数,成功获取跨域服务器上的json数据后,会动态执行这个callback函数
		// if (json.actionErrors.length != 0) {
		// alert(json.actionErrors);
		// }
		// // genDynamicContent(qsData, type, json);
		// },
		// complete : function(XMLHttpRequest, textStatus) {
		// // $.unblockUI({
		// // fadeOut : 10
		// // });
		// },
		// error : function(xhr) {
		// // jsonp 方式此方法不被触发.原因可能是dataType如果指定为jsonp的话,就已经不是ajax事件了
		// // 请求出错处理
		// alert("请求出错(请检查相关度网络状况.)");
		// }
		// });

	});

//});

// var wordInput = $("#word");
// var wordInputOffset = wordInput.offset();
// // // 自动补全框最开始应该隐藏起来
// // $("#auto").hide().css("border", "1px black
// // solid").css("position",
// // "absolute").css("top",
// // wordInputOffset.top + wordInput.height() + 5 + "px").css(
// // "left", wordInputOffset.left + "px").width(
// // wordInput.width() + 2);
//
// // 给文本框添加键盘按下并弹起的事件
// wordInput.keyup(function(event) {
// // 处理文本框中的键盘事件
// var myEvent = event || window.event;
// var keyCode = myEvent.keyCode;
// // 如果输入的是字母，应该将文本框中最新的信息发送给服务器
// // 如果输入的是退格键或删除键，也应该将文本框中的最新信息发送给服务器
// if (keyCode >= 65 && keyCode <= 90 || keyCode == 8
// || keyCode == 46) {
// // 1.首先获取文本框中的内容
// var wordText = $("#word").val();
// var autoNode = $("#auto");
// if (wordText != "") {
//
// $.ajax({
//
// type : "POST",
// url : "AutoComplete.do",
// data : "word=" + wordText,
// dataType : 'text',
// success : function(data) {
//
// // alert(data);
//
// var jqueryObj = $(data);
// // 找到所有的word节点
// var wordNodes = jqueryObj.find("word");
// // 遍历所有的word节点，取出单词内容，然后将单词内容添加到弹出框中
// // 需要清空原来的内容
// autoNode.html("");
// wordNodes.each(function() {
// // 获取单词内容
// var wordNode = $(this);
// // 新建div节点，将单词内容加入到新建的节点中
// // 将新建的节点加入到弹出框的节点中
// $("<div>").html(wordNode.text()).appendTo(
// autoNode);
// });
// // 如果服务器段有数据返回，则显示弹出框
// if (wordNodes.length > 0) {
// autoNode.show();
// } else {
// autoNode.hide();
// // 弹出框隐藏的同时，高亮节点索引值也制成-1
// highlightindex = -1;
// }
//
// // alert('系统提示', '恭喜，密码修改成功！<br>您的新密码为：'
// // );
// // $newpass.val('');
// // $rePass.val('');
// // close();
// // closePwd();
// }
// });

// // 2.将文本框中的内容发送给服务器段
// $.post("AutoComplete.do", {
// word : wordText
// }, function(data) {
// // 将dom对象data转换成JQuery的对象
//
// alert(data);
//
// var jqueryObj = $(data);
// // 找到所有的word节点
// var wordNodes = jqueryObj.find("word");
// // 遍历所有的word节点，取出单词内容，然后将单词内容添加到弹出框中
// // 需要清空原来的内容
// autoNode.html("");
// wordNodes.each(function() {
// // 获取单词内容
// var wordNode = $(this);
// // 新建div节点，将单词内容加入到新建的节点中
// // 将新建的节点加入到弹出框的节点中
// $("<div>").html(wordNode.text()).appendTo(
// autoNode);
// });
// // 如果服务器段有数据返回，则显示弹出框
// if (wordNodes.length > 0) {
// autoNode.show();
// } else {
// autoNode.hide();
// // 弹出框隐藏的同时，高亮节点索引值也制成-1
// highlightindex = -1;
// }
// }, "xml");
// } else {
// autoNode.hide();
// highlightindex = -1;
// }
// } else if (keyCode == 38 || keyCode == 40) {
// // 如果输入的是向上38向下40按键
// if (keyCode == 38) {
// // 向上
// var autoNodes = $("#auto").children("div")
// if (highlightindex != -1) {
// // 如果原来存在高亮节点，则将背景色改称白色
// autoNodes.eq(highlightindex).css(
// "background-color", "white");
// highlightindex--;
// } else {
// highlightindex = autoNodes.length - 1;
// }
// if (highlightindex == -1) {
// // 如果修改索引值以后index变成-1，则将索引值指向最后一个元素
// highlightindex = autoNodes.length - 1;
// }
// // 让现在高亮的内容变成红色
// autoNodes.eq(highlightindex).css("background-color",
// "red");
// }
// if (keyCode == 40) {
// // 向下
// var autoNodes = $("#auto").children("div")
// if (highlightindex != -1) {
// // 如果原来存在高亮节点，则将背景色改称白色
// autoNodes.eq(highlightindex).css(
// "background-color", "white");
// }
// highlightindex++;
// if (highlightindex == autoNodes.length) {
// // 如果修改索引值以后index变成-1，则将索引值指向最后一个元素
// highlightindex = 0;
// }
// // 让现在高亮的内容变成红色
// autoNodes.eq(highlightindex).css("background-color",
// "red");
// }
// } else if (keyCode == 13) {
// // 如果输入的是回车
//
// // 下拉框有高亮内容
// if (highlightindex != -1) {
// // 取出高亮节点的文本内容
// var comText = $("#auto").hide().children("div").eq(
// highlightindex).text();
// highlightindex = -1;
// // 文本框中的内容变成高亮节点的内容
// $("#word").val(comText);
// } else {
// // 下拉框没有高亮内容
// alert("文本框中的[" + $("#word").val() + "]被提交了");
// }
// }
// });
//
// // 给按钮添加事件，表示文本框中的数据被提交
// $("input[type='button']").click(function() {
// alert("文本框中的[" + $("#word").val() + "]被提交了");
// });
// })

// // JavaScript Document
// jQuery
// .extend({
//
// createUploadIframe : function(id, uri) {
// // create frame
// var frameId = 'jUploadFrame' + id;
//
// if (window.ActiveXObject) {
// var io = document.createElement('<iframe id="' + frameId
// + '" name="' + frameId + '" />');
// if (typeof uri == 'boolean') {
// io.src = 'javascript:false';
// } else if (typeof uri == 'string') {
// io.src = uri;
// }
// } else {
// var io = document.createElement('iframe');
// io.id = frameId;
// io.name = frameId;
// }
// io.style.position = 'absolute';
// io.style.top = '-1000px';
// io.style.left = '-1000px';
//
// document.body.appendChild(io);
//
// return io;
// },
// createUploadForm : function(id, fileElementId) {
// // create form
// var formId = 'jUploadForm' + id;
// var fileId = 'jUploadFile' + id;
// var form = jQuery('<form action="" method="POST" name="'
// + formId + '" id="' + formId
// + '" enctype="multipart/form-data"></form>');
// var oldElement = jQuery('#' + fileElementId);
// var newElement = jQuery(oldElement).clone();
// jQuery(oldElement).attr('id', fileId);
// jQuery(oldElement).before(newElement);
// jQuery(oldElement).appendTo(form);
// // set attributes
// jQuery(form).css('position', 'absolute');
// jQuery(form).css('top', '-1200px');
// jQuery(form).css('left', '-1200px');
// jQuery(form).appendTo('body');
// return form;
// },
//
// ajaxFileUpload : function(s) {
// // TODO introduce global settings, allowing the client to modify
// // them for all requests, not only timeout
// s = jQuery.extend({}, jQuery.ajaxSettings, s);
// var id = s.fileElementId;
// var form = jQuery.createUploadForm(id, s.fileElementId);
// var io = jQuery.createUploadIframe(id, s.secureuri);
// var frameId = 'jUploadFrame' + id;
// var formId = 'jUploadForm' + id;
//
// if (s.global && !jQuery.active++) {
// // Watch for a new set of requests
// jQuery.event.trigger("ajaxStart");
// }
// var requestDone = false;
// // Create the request object
// var xml = {};
// if (s.global) {
// jQuery.event.trigger("ajaxSend", [ xml, s ]);
// }
//
// var uploadCallback = function(isTimeout) {
// // Wait for a response to come back
// var io = document.getElementById(frameId);
// try {
// if (io.contentWindow) {
// xml.responseText = io.contentWindow.document.body ?
// io.contentWindow.document.body.innerHTML
// : null;
// xml.responseXML = io.contentWindow.document.XMLDocument ?
// io.contentWindow.document.XMLDocument
// : io.contentWindow.document;
//
// } else if (io.contentDocument) {
// xml.responseText = io.contentDocument.document.body ?
// io.contentDocument.document.body.innerHTML
// : null;
// xml.responseXML = io.contentDocument.document.XMLDocument ?
// io.contentDocument.document.XMLDocument
// : io.contentDocument.document;
// }
// } catch (e) {
// jQuery.handleError(s, xml, null, e);
// }
// if (xml || isTimeout == "timeout") {
// requestDone = true;
// var status;
// try {
// status = isTimeout != "timeout" ? "success"
// : "error";
// // Make sure that the request was successful or
// // notmodified
// if (status != "error") {
// // process the data (runs the xml through
// // httpData regardless of callback)
// var data = jQuery.uploadHttpData(xml,
// s.dataType);
// if (s.success) {
// // ifa local callback was specified, fire it
// // and pass it the data
// s.success(data, status);
// }
// ;
// if (s.global) {
// // Fire the global callback
// jQuery.event.trigger("ajaxSuccess", [ xml,
// s ]);
// }
// ;
// } else {
// jQuery.handleError(s, xml, status);
// }
//
// } catch (e) {
// status = "error";
// jQuery.handleError(s, xml, status, e);
// }
// ;
// if (s.global) {
// // The request was completed
// jQuery.event.trigger("ajaxComplete", [ xml, s ]);
// }
// ;
//
// // Handle the global AJAX counter
// if (s.global && !--jQuery.active) {
// jQuery.event.trigger("ajaxStop");
// }
// ;
// if (s.complete) {
// s.complete(xml, status);
// }
// ;
//
// jQuery(io).unbind();
//
// setTimeout(function() {
// try {
// jQuery(io).remove();
// jQuery(form).remove();
//
// } catch (e) {
// jQuery.handleError(s, xml, null, e);
// }
//
// }, 100);
//
// xml = null;
//
// }
// ;
// }
// // Timeout checker
// if (s.timeout > 0) {
// setTimeout(function() {
//
// if (!requestDone) {
// // Check to see ifthe request is still happening
// uploadCallback("timeout");
// }
//
// }, s.timeout);
// }
// try {
// var form = jQuery('#' + formId);
// jQuery(form).attr('action', s.url);
// jQuery(form).attr('method', 'POST');
// jQuery(form).attr('target', frameId);
// if (form.encoding) {
// form.encoding = 'multipart/form-data';
// } else {
// form.enctype = 'multipart/form-data';
// }
// jQuery(form).submit();
//
// } catch (e) {
// jQuery.handleError(s, xml, null, e);
// }
// if (window.attachEvent) {
// document.getElementById(frameId).attachEvent('onload',
// uploadCallback);
// } else {
// document.getElementById(frameId).addEventListener('load',
// uploadCallback, false);
// }
// return {
// abort : function() {
// }
// };
//
// },
//
// uploadHttpData : function(r, type) {
// var data = !type;
// data = type == "xml" || data ? r.responseXML : r.responseText;
// // ifthe type is "script", eval it in global context
// if (type == "script") {
// jQuery.globalEval(data);
// }
//
// // Get the JavaScript object, ifJSON is used.
// if (type == "json") {
// eval("data = " + data);
// }
//
// // evaluate scripts within html
// if (type == "html") {
// jQuery("<div>").html(data).evalScripts();
// }
//
// return data;
// }
// });
