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

<title>My JSP 'address_form.jsp' starting page</title>

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
		var name = $("name");
		var address = $("address");
		var postalCode = $("postalCode");
		var mobile = $("mobile");
		var phone = $("phone");

		var email_reg = /^\w+@\w+.[a-zA-Z]{2,3}(.[a-zA-Z]{2,3})?$/;
		var mobile_reg = /^[0-9]{11}/;
		var phone_reg = /^[0-9]{6,20}/;
		var postalCode_reg = /^[0-9]{6}/;
		if (name == "") {
			alert("名字不能为空");
			return false;
		}
		if (address == "") {
			alert("地址不能为空");
			return false;
		}
		if (postalCode == "") {
			alert("邮编不能为空");
			return false;
		}
		if (postalCode_reg.test(postalCode) == false) {
			alert("邮编格式错误,6位");
			return false;
		}
		if (mobile == "") {
			alert("手机不能为空");
			return false;
		}
		if (mobile_reg.test(mobile) == false) {
			alert("手机格式错误");
			return false;
		}
		if (phone == "") {
			alert("电话不能为空");
			return false;
		}
		if (phone_reg.test(phone) == false) {
			alert("电话格式错误");
			return false;
		}
	}
</script>
</head>

<body>
	<div style="border: 1px solid;">

		<h1>选择收货地址</h1>
		<table border="1" style="width: 600px;">
			<tr>
				<td>名字</td>
				<td>地址</td>
				<td>邮编</td>
				<td>手机</td>
				<td>电话</td>
				<td>选择地址</td>
			</tr>
			<s:iterator value="#request.addresslist" status="ul">
				<tr>
					<td>${receiveName}</td>
					<td>${fullAddress}</td>
					<td>${postalCode}</td>
					<td>${mobile}</td>
					<td>${phone}</td>
					<td><a
						href='<s:url action="placeOrder"><s:param name="receiveAddress.id" value="id" /></s:url>'>选择这个地址</a></td>
				</tr>
			</s:iterator>

		</table>
	</div>
	<br />
	<div style="border: 1px solid;">
		<h1>添加收货地址</h1>
		<s:form action="addReceiveAddress" onsubmit="return checkForm();">

			<table border="1" style="width: 600px;">

				<tr>
					<s:textfield label="名字" id="name" name="receiveAddress.receiveName"></s:textfield>
					<s:textfield label="地址" id="address" name="receiveAddress.fullAddress"></s:textfield>
					<s:textfield label="邮编" id="postalCode" name="receiveAddress.postalCode"></s:textfield>
					<s:textfield label="手机" id="mobile" name="receiveAddress.mobile"></s:textfield>
					<s:textfield label="电话" id="phone" name="receiveAddress.phone"></s:textfield>
				</tr>
				<tr>
					<s:submit value="确认地址"></s:submit>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>
