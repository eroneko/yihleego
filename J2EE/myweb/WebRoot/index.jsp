<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<title>YihLeego</title>


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="YihLeego,yihleego,喱果">
<meta http-equiv="description"
	content="YihLeego个人网页">
<meta NAME="keywords" content="YihLeego,yihleego,喱果">
<meta NAME="description" content="YihLeego个人网页">
<META NAME="COPYRIGHT" CONTENT="YihLeego">

<link href="css/style.css" rel="stylesheet" media="all" />
<script src="js/jquery.min.js"></script>


<script type="text/javascript">
	function checkForm() {
		var message = document.getElementById("feedback").value;
		var email_reg = /^\w+@\w+.[a-zA-Z]{2,3}(.[a-zA-Z]{2,3})?$/;
		if (message == "" || message == "Input your message:") {
			alert("Feed back not null!");
			return false;
		}
	}
	jQuery(document).ready(
			function($) {
				var offset = 300,
				offset_opacity = 1200,
				scroll_top_duration = 700,
				$back_to_top = $('.cd-top');
				$(window).scroll(
						function() {
							($(this).scrollTop() > offset) ? $back_to_top
									.addClass('cd-is-visible') : $back_to_top
									.removeClass('cd-is-visible cd-fade-out');
							if ($(this).scrollTop() > offset_opacity) {
								$back_to_top.addClass('cd-fade-out');
							}
						});
				$back_to_top.on('click', function(event) {
					event.preventDefault();
					$('body,html').animate({
						scrollTop : 0,
					}, scroll_top_duration);
				});

			});
</script>
</head>

<body>
	<div class="header">
		<div class="wrap">
			<div class="logo">
				<a href="toIndex.jsp" title="Click to Index">YIHLEEGO</a>
			</div>

			<div class="top-nav">
				<ul>

					<%
						if (session.getAttribute("LOGINUSER") == null) {
					%>
					<li class="active"><a href="login_form.jsp" class="scroll">Login</a></li>
					<li><a href="register_form.jsp" class="scroll">Register</a></li>
					<%
						} else {
					%>
					<li class="active"><a href="toEditUser" class="scroll">${LOGINUSER.nickname}</a></li>
					<li><a href="logout" class="scroll">Logout</a></li>
					<%
						}
					%>
					<!-- <li><iframe
							src="http://music.163.com/outchain/player?type=2&amp;id=426026279&amp;auto=0&amp;height=32"
							width="298" height="50"> </iframe></li> -->
				</ul>
			</div>

			<div class="clear"></div>

		</div>
	</div>


	<div class="content">
		<div class="grid1" id="me">
			<a href="javascript:void(0);"> <img src="./images/head.jpg"
				title="初めまして 私はりごです どうぞ よろしくお願いします。" />
			</a>
			<p>&nbsp;</p>
			<h2>Hi,I'm YihLeego</h2>
			<p><a href="https://github.com/yihleego/yihleego">Click Here >> GitHub</a></p>
			<p></p>
		</div>



		<s:iterator value="#request.items">
			<div class="grid3">
				<div class="grid3-header"></div>
				<div class="grid3-content">
					<div class="grid3-left">
						<h3>
							<a href="itemDetail?id=${id}">${title}</a>
						</h3>
						<p>${description}</p>
						<a class="button" href="itemDetail?id=${id}">View Detail</a>
					</div>
					<div class="grid3-right">
						<a href="itemDetail?id=${id}"> <img alt="${title}"
							src="images/${img}" width="100%">
						</a>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</s:iterator>
		
	<div class="grid3" id="paging">
		<div class="grid3-header" id="main"></div>
			<div class="grid3-content" align="center">
				<ul class="pagination handWrite">
					<s:iterator value="pageSum" var="var" status="sta">
						<s:if test="#var==1">
							<s:if test="#var==#request.page">
								<li class="disabled"><a href="javascript:void(0);">«</a></li>
							</s:if>
							<s:else>
								<li><a href="page?page=${page-1}">«</a></li>
							</s:else>
						</s:if>
						<s:if test="#var==#request.page">
							<li class="active"><a href="javascript:void(0);"><s:property /></a></li>
						</s:if>
						<s:else>
							<li><a href="page?page=<s:property/>"><s:property /></a></li>
						</s:else>
						<s:if test="#sta.last==true">
							<s:if test="#var==#request.page">
								<li class="disabled"><a href="javascript:void(0);">»</a></li>
							</s:if>
							<s:else>
								<li><a href="page?page=${page+1}">»</a></li>
							</s:else>
						</s:if>
					</s:iterator>
				</ul>
			</div>
		</div>
	

		<div class="twiiter-box">
			<a href="javascript:void(0);"><img src="./images/twitt.png"
				title="twitter-count" /></a>
			<p>
				Twitter <a href="javascript:void(0);">#YihLeego</a>
			</p>
		</div>
		<div class="contact" id="contact">
			<h3>Feed Back</h3>
			<p>Now it works!</p>
			<form action="doEmail" method="post" onsubmit="return checkForm();">
				<!-- 	<input type="text" class="textbox" value="Input your name:" name="uname" id="name"
					onfocus="if (this.value == 'Input your name:') {this.value = '';}"
					onblur="if (this.value == '') {this.value = 'Input your name:';}">
				<input type="text" class="textbox" value="Input your email:" name="uemail" id="email"
					onfocus="if (this.value == 'Input your email:') {this.value = '';}"
					onblur="if (this.value == '') {this.value = 'Input your email:';}"> -->
				<input type="hidden" class="textbox" value="${LOGINUSER.nickname}"
					name="u.nickname"> <input type="hidden" class="textbox"
					value="${LOGINUSER.email}" name="u.email">
				<textarea value="Input your message:" name="feedback" id="feedback"
					onfocus="if (this.value == 'Input your message:') {this.value = '';}"
					onblur="if (this.value == '') {this.value = 'Input your message:';}">Input your message:</textarea>
				<input type="submit" value="Send">
			</form>
		</div>
		<div class="catch-me">
			<h3>SAY HELLO</h3>
			<p>&nbsp;</p>
			<ul>
				<li><a href="javascript:void(0);"><img
						src="./images/facebook.png" title="Facebook" /></a></li>
				<li><a href="javascript:void(0);"><img
						src="./images/rss.png" title="Rss" /></a></li>
				<li><a href="javascript:void(0);"><img
						src="./images/googlepluse.png" title="Google Plus" /></a></li>
			</ul>
		</div>
		<div class="footer">
			<p>
				Design by <a href="javascript:void(0);">YihLeego</a>
			</p>
		</div>

	</div>
	<a href="#0" class="cd-top">Top</a>
</body>
</html>
