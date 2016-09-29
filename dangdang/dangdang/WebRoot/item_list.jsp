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
    
    <title>My JSP 'item_list.jsp' starting page</title>
    
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
				<td>商品名称</td>
				<td>价格</td>
				<td>商品数量</td>
				<td>总金额</td>
			
			</tr>
			
			<s:iterator value="#request.order.DItems" status="or">
				<tr>
			
					<td>${productName}</td>
					<td>${dangPrice}</td>
					<td>${productNum}</td>
					<td>${amount}</td>
				</tr>
				</s:iterator>		
		
		</table>
		<input type="button" value="返回首页" onclick="location.href='main.jsp'" />
	</div>
  </body>
</html>
