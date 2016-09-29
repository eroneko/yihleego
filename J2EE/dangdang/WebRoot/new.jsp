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

<title>最新上架图书</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
a, a:link, a:visited, a:active, a:hover {
	color: #4169E1;
	text-decoration: none;
	font-weight: bold;
	font-size: 15px;
}

#new {
	float: left; 
	width : 100%;
	background-color: silver;
	padding: 0px;
	margin: 0px;
}
</style>
</head>

<body>
	<div id="new" align="center">
		<div style="widows: 100%;padding: 0px;margin: 0px;height:50px;">
			<h2 style="color:white;background-color:gray;"><input style="float: left;height: 50%;" type="button" value="返回上一页" onclick="history.back()" />最新上架图书</h2>
		</div>
		<s:iterator value="#request.newlist">
			<div style="float: left;width: 24%;border: 1px;">
				<table border="0" width="80%">
					<tr>
						<td style="width: 100px"><img src="./images/${productPic}"
							width="100px" height="150px"  /></td>
					</tr>
					<tr>
						<td><a
							href='<s:url action="findbook"><s:param name="product.id" value="id" /></s:url>'>${productName}</a>
						</td>
					</tr>
					<tr>
						<td>定价：${fixedPrice}元</td>
					</tr>
					<tr>
						<td>当当价：${dangPrice}元</td>
					</tr>
				</table>
			</div>
		</s:iterator>

	</div>

</body>
</html>
