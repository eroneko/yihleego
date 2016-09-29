<%@page import="po.DProduct"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Cart.jsp' starting page</title>

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
<s:form action="showReceiveAddress">
<table border="1"><tr>
				<td width="200px">名称</td>
				<td width="100px">价格(元)</td>
				<td width="100px">数量</td>
				<td width="100px">操作</td></tr>
	<s:iterator value="#request.cartlist" >	
			<tr>
				<td>《${productName}》</td>
				<td>${dangPrice}</td>
				<td>${num}</td>
				<td><a href='<s:url action="deletecart"><s:param name="id" value="id" /></s:url>'>删除</a></td>
			</tr>
		</s:iterator>

		<tr>
		<td><b>总价：${sum}元</b></td>
		<td colspan="2"><input type="submit" value="购买"	/></td>
		<td><a href='<s:url action="deleteallcart"></s:url>'>清空购物车</a></td>
		</tr>
</table>
<input type="button" value="返回首页" onclick="location.href='main.jsp'" />
</s:form>

</body>
</html>
