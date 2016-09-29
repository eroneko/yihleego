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

<title>注册</title>

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
		var nickname = $("nickname");
		var email = $("email");
		var password = $("password");
		var repassword = $("repassword");
		
		var email_reg = /^\w+@\w+.[a-zA-Z]{2,3}(.[a-zA-Z]{2,3})?$/;
		var password_reg = /^.{6,20}/;
		
		if (nickname == "Nickname"||nickname =="") {
			alert("昵称不能为空!");
			return false;
		}
		if (ChineseCharactersCount(nickname) > 20 ||ChineseCharactersCount(nickname) < 4) {
			alert("昵称格式错误,4~20个字符(汉字占2个字符)!");
			return false;
		}
		if (email == ""||email=="mail@address.com") {
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


<div id="login">

		<h2><span class="fontawesome-lock"></span>Register${REGISTERMSG}</h2>

		<form action="register" method="POST" onsubmit="return checkForm();">

			<fieldset>
				<p><label for="nickname">Nickname</label></p>
				<p><input type="nickname" id="nickname" name="u.nickname" value="Nickname" onBlur="if(this.value=='')this.value='Nickname'" onFocus="if(this.value=='Nickname')this.value=''"></p>
				
				<p><label for="email">E-mail address</label></p>
				<p><input type="email" id="email" name="u.email" value="mail@address.com" onBlur="if(this.value=='')this.value='mail@address.com'" onFocus="if(this.value=='mail@address.com')this.value=''"></p>

				<p><label for="password">Password</label></p>
				<p><input type="password" id="password" name="u.password"></p>
				
				<p><label for="password">RePassword</label></p>
				<p><input type="password" id="repassword"></p>
				
			
				<p>
					<input type="submit" value="Register">
					<input type="button" value="GoBack" onclick="javascript:history.back();">
					<input type="button" value="Home" class="floatright" onclick="javascript:window.location.href='toIndex.jsp';">
				</p>

			</fieldset>

		</form>

	</div> <!-- end login -->

<%-- <div align="center">
	<s:form action="register" onsubmit="return checkForm();"
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
			
				<td colspan="2"><s:submit value="注册"></s:submit></td>
			</tr>
		</table>
	</s:form>
	<a href="login_form.jsp">返回登陆</a>
	
	</div> --%>
</body>
</html>
