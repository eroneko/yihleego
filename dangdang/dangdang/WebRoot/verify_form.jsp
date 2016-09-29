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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<b>您好${u.nickname}，邮箱验证码已经发送至${u.email}，请去邮箱确认。</b><br />
	<b style="color: red;">${VERIFYCODE}</b>
	<s:form action="addemailverifycode">
		<s:hidden label="id" name="u.id" id="id"></s:hidden>
		<s:textfield label="请输入邮箱验证码" name="u.emailVerifyCode"></s:textfield>
		<s:submit value="验证邮箱"></s:submit>
	</s:form>
</body>
</html>
