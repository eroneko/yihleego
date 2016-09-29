<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editUser.jsp' starting page</title>
    
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
		var oldpassword = $("oldpassword");
		var password = $("password");
		var repassword = $("repassword");
		var password_reg = /^.{6,20}/;
		if (oldpassword == "") {
			alert("旧密码不能为空");
			return false;
		}
		if (password == "") {
			alert("密码不能为空");
			return false;
		}
		if (repassword == "") {
			alert("重复密码不能为空");
			return false;
		}
		if (password_reg.test(password) == false) {
			alert("密码格式错误,6~20个字符!");
			return false;
		}
		if (password != repassword) {
			alert("密码不一致!");
			return false;
		}
	}

</script>
  </head>
  
  <body>
    <s:form action="updateuser"  method="post"	onsubmit="return checkForm()">
			<table border="0">
				<tr>
					<td><s:textfield label="旧密码" name="oldpassword" id="oldpassword"></s:textfield></td>
				</tr>
				<tr>
					<td><s:password label="新密码" name="u.password" id="password"></s:password></td>
				</tr>
				<tr>
					<td><s:password label="重复密码" name="repassword" id="repassword"></s:password></td>
				</tr>
				<tr>
					<td colspan="2"><s:submit value="修改密码"></s:submit></td>
				</tr>

			</table>
		</s:form>
  </body>
</html>
