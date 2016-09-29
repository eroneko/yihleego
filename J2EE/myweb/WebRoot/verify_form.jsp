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

<title>邮箱验证</title>

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
		var code = $("verifycode");
	
		
		var code_reg = /^[A-Za-z0-9]{8}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{4}-[A-Za-z0-9]{12}/;
	
		
		if (code == "VerifyCode"||code =="") {
			alert("昵称不能为空!");
			return false;
		}
		if (code_reg.test(code) == false) {
			alert("验证码格式错误!");
			return false;
		}
	


	}
</script>
</head>

<body>
<div id="login">

		<h2><span class="fontawesome-lock"></span>VerifyCode${VERIFYCODE}</h2>

		<form action="checkemailverifycode" method="POST" onsubmit="return checkForm();">

			<fieldset>
				<p><label for="VerifyCode">您好${u.nickname}，验证码已发送至您的邮箱：${u.email}</label></p>
				<p><input type="VerifyCode" id=verifycode name="u.emailVerifyCode" value="VerifyCode" onBlur="if(this.value=='')this.value='VerifyCode'" onFocus="if(this.value=='VerifyCode')this.value=''"></p>
				<p>
				<input type="submit" value="Submit">
				<input type="button" value="GoBack" onclick="javascript:history.back();">
				<input type="button" value="Home" class="floatright" onclick="javascript:window.location.href='toIndex.jsp';">
				</p>

			</fieldset>

		</form>

	</div>
	
	
<%-- 	<b>您好${u.nickname}，邮箱验证码已经发送至${u.email}，请去邮箱确认。</b><br />
	<b style="color: red;">${VERIFYCODE}</b>
	<s:form action="checkemailverifycode">
		<s:hidden label="id" name="u.id" id="id"></s:hidden>
		<s:textfield label="请输入邮箱验证码" name="u.emailVerifyCode"></s:textfield>
		<s:submit value="验证邮箱"></s:submit>
	</s:form> --%>
</body>
</html>
