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

<title>注册当当</title>

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
		return document.getElementById(id);
	}
	function checkForm() {
		var nickname = $("nickname").value;
		var email = $("email").value;
		var password = $("password").value;
		var repassword = $("repassword").value;
		var verificationcode = $("rand").value;
		
		var email_reg = /^\w+@\w+.[a-zA-Z]{2,3}(.[a-zA-Z]{2,3})?$/;
		var password_reg = /^.{6,20}/;
		if (nickname == "") {
			alert("昵称不能为空!");
			return false;
		}
		if (ChineseCharactersCount(nickname) > 20 ||ChineseCharactersCount(nickname) < 4) {
			alert("昵称格式错误,4~20个字符(汉字占2个字符)!"+ChineseCharactersCount(nickname));
			return false;
		}
		if (email == "") {
			alert("邮箱不能为空!");
			return false;
		}
		if (email_reg.test(email) == false) {
			alert("邮箱格式错误!");
			return false;
		}
		if (password == "") {
			alert("密码不能为空!");
			return false;
		}
		if (password_reg.test(password) == false) {
			alert("密码格式错误,6~20个字符!");
			return false;
		}
		if (repassword == "") {
			alert("重复密码不能为空!");
			return false;
		}
		if (password != repassword) {
			alert("密码不一致!");
			return false;
		}
		if (verificationcode == "") {
			alert("验证码不能为空!");
			return false;
		}

	}
	function loadimage() {
		document.getElementById("randImage").src = "image.jsp?" + Math.random();
	}
	function ChineseCharactersCount(chars) {
		var sum = 0;
		for (var i = 0; i < chars.length; i++) {
			var c = chars.charCodeAt(i);
			if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
				sum++;
			} else {
				sum += 2;
			}
		}
		return sum;
	}
</script>
</head>

<body>
<div align="center">
	<s:form action="register_validate.jsp" onsubmit="return checkForm();"
		method="post">
		<table border="0">
			<tr>
				<s:textfield label="昵称" name="u.nickname" id="nickname"></s:textfield>
				<b style="color: red;">${REGISTERMSG}</b>
			</tr>
			<tr>
				<s:textfield label="邮箱" name="u.email" id="email"></s:textfield>
				
			</tr>
			<tr>
				<s:textfield label="密码" name="u.password" id="password"></s:textfield>
			</tr>
			<tr>
				<s:textfield label="重复密码" id="repassword"></s:textfield>
			</tr>
			<tr>
				<s:textfield label="验证码" id="rand" name="rand"></s:textfield>
				<td align="center"><img name="randImage" id="randImage"
					src="image.jsp" width="60" height="20" border="1"
					onclick="javascript:loadimage();"></td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="注册"></s:submit></td>
			</tr>
		</table>
	</s:form>
	</div>
</body>
</html>
