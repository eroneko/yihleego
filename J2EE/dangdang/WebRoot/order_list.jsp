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

<title>My JSP 'order_list.jsp' starting page</title>

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
	<div>
		<table border="1">
			<tr>
				<td>订单编号</td>
				<td>订单状态</td>
				<td>订单时间</td>
				<td>总金额</td>
				<td>收件人</td>
				<td>收件地址</td>
				<td>邮编</td>
				<td>手机号码</td>
				<td>电话号码</td>
				<td>详情</td>
			</tr>
			<s:iterator value="#request.orderlist">

				<tr>
					<td>${id}</td>
					<td>${status}</td>
					<td>${orderTime}</td>
					<td>${totalPrice}</td>
					<td>${receiveName}</td>
					<td>${fullAddress}</td>
					<td>${postalCode}</td>
					<td>${mobile}</td>
					<td>${phone}</td>
					<td>
						<a href='<s:url action="itemList"><s:param name="order.id" value="id"/></s:url>'>
							查看订单详情
						</a>
					</td>
				</tr>

			</s:iterator>
		</table>
		<input type="button" value="返回首页" onclick="location.href='main.jsp'" />
	</div>
</body>
</html>
