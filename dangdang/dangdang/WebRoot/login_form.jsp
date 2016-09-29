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

<title>登陆当当</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function $(id) {
		return document.getElementById(id).value;
	}
	function checkForm() {
		var email = $("email");
		var password = $("password");
		var verificationcode = $("rand");
		if (email == "") {
			alert("邮箱不能为空");
			return false;
		}
		if (password == "") {
			alert("密码不能为空");
			return false;
		}
		if (verificationcode == "") {
			alert("验证码不能为空");
			return false;
		}
	}
	function loadimage() {
		document.getElementById("randImage").src = "image.jsp?" + Math.random();
	}
</script>
</head>

<body>

	<div align="center">
		<b style="color: red;">${LOGINMSG}</b>
		<s:form action="login_validate.jsp" name="validate" method="post"
			onsubmit="return checkForm()">
			<table border="0">
				<tr>
					<td><s:textfield label="邮箱" name="u.email" id="email"></s:textfield></td>
				</tr>
				<tr>
					<td><s:password label="密码" name="u.password" id="password"></s:password></td>
				</tr>
				<tr>
					<td><s:textfield label="验证码" name="rand" id="rand"></s:textfield></td>
					<td align="center"><img name="randImage" id="randImage"
						src="image.jsp" width="60" height="20" border="1"
						onclick="javascript:loadimage();"></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit value="登录"></s:submit></td>
				</tr>

			</table>
		</s:form>
		<b>没有账号？</b><a href="./register_form.jsp">马上注册</a>

	</div>
</body>
</html>
