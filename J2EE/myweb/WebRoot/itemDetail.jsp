<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="dateValue" class="java.util.Date" />
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
<title>${item.title}</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="YihLeego,yihleego,喱果">
<meta http-equiv="description"
	content="YihLeego个人网页">
<meta NAME="keywords" content="YihLeego,yihleego,喱果">
<meta NAME="description"
	content="YihLeego个人网页">
<META NAME="COPYRIGHT" CONTENT="YihLeego">


<link href="css/style.css" rel="stylesheet" media="all" />

<script type="text/javascript">
	function $(id) {
		return document.getElementById(id).value;
	}
	function checkForm() {

		var message = $("message");

		if (message == "" || message == "Leave a comment down below.") {
			alert("内容不能为空");
			return false;
		}

	}
</script>
</head>

<body>
	<div class="header">
		<div class="wrap">
			<div class="logo">
				<a href="toIndex.jsp" title="Click to Index">HOME</a>
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


	<div class="content" id="main">
		<div class="grid1" id="description">
			<h2>${item.title}</h2>
			<p>${item.description}</p>
			<p>${item.href}</p>	
		</div>
		
		<div class="grid3" id="item">
			<div class="grid3-content">
				<div class="grid3-unity">
					<p align="center">${item.frame}</p>
				</div>


				<div class="comment" id="comment">
				
					<form class="form-horizontal" action="leaveComment" method="post"
						onsubmit="return checkForm();">
						<h3 style="color: black;">留言板</h3>

						<textarea value="Leave a comment down below." name="message.message"
							id="message"
							onfocus="if (this.value == 'Leave a comment down below.') {this.value = '';}"
							onblur="if (this.value == '') {this.value = 'Leave a comment down below.';}">Leave a comment down below.</textarea>
						<input type="hidden" name="u.id" value="${LOGINUSER.id}">
						<input type="hidden" name="id" value="${item.id}"> <input
							type="submit" value="Submit">

					</form>


					<div class="catch-me" id="commentborad" >
						<s:iterator value="#request.item.TMessageboards">
							<div id="commentRow">
							<div class="grid3-header"></div>
								<jsp:setProperty name="dateValue" property="time"
									value="${addtime}" />
								<div class="bs-component" align="left" >
									<p>${TUser.nickname}:</p>
									<p>${message}</p>
									<p style="font-size: 0.5em;">
										<fmt:formatDate value="${dateValue}"
											pattern="yyyy/MM/dd HH:mm" />
									</p>
								</div>
								
							</div>
							
						</s:iterator>
					</div>


				</div>
			</div>




		</div>
	</div>





</body>
</html>
