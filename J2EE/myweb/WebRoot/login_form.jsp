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

	<title>Login</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/user.css">
<script type="text/javascript">
	function $(id) {
		return document.getElementById(id).value;
	}
	function checkForm() {
		var email = $("email");
		var password = $("password");
	
		if (email == ""||email=="mail@address.com") {
			alert("邮箱不能为空");
			return false;
		}
		if (password == "") {
			alert("密码不能为空");
			return false;
		}
		
	}
	
</script>
</head>

<body>
	<div id="login">

		<h2>
			<span class="fontawesome-lock"></span>Login${LOGINMSG}
		</h2>

		<form action="login" method="post" onsubmit="return checkForm();">

			<fieldset>

				<p>
					<label for="email">E-mail address</label>
				</p>
				<p>
					<input type="email" id="email" name="u.email"
						value="mail@address.com"
						onBlur="if(this.value=='')this.value='mail@address.com'"
						onFocus="if(this.value=='mail@address.com')this.value=''">
				</p>
				<p>
					<label for="password">Password</label>
				</p>
				<p>
					<input type="password" id="password" name="u.password">
				</p>

				<p>
					<input type="submit" value="Login">
					<input type="button" value="Register" onclick="javascript:window.location.href='register_form.jsp';">
					<input type="button" value="Home" class="floatright" onclick="javascript:window.location.href='toIndex.jsp';">
				</p>

			</fieldset>

		</form>

	</div>

	<!-- end login -->
	
<%-- 	<div align="center">
		<b style="color: red;">${LOGINMSG}</b>
		<s:form action="login" method="post" onsubmit="return checkForm()">
			<table border="0">
				<tr>
					<td><s:textfield label="邮箱" name="u.email" id="email"></s:textfield></td>
				</tr>
				<tr>
					<td><s:password label="密码" name="u.password" id="password"></s:password></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit value="登录"></s:submit></td>
				</tr>

			</table>
		</s:form>
		<b>没有账号？</b><a href="./register_form.jsp">马上注册</a>

	</div> --%>
</body>
</html>
