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

<title>${cat_name}</title>

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

#booklist {
	float: left;
	width: 100%;
	background-color: silver;
	padding: 0px;
	margin: 0px;
}
</style>
</head>

<body>

	<div id="booklist" align="center">
		<div style="widows: 100%;padding: 0px;margin: 0px;height:50px">
			<h2 style="color:white;background-color:gray;"><input style="float: left;height: 50%;" type="button" value="返回上一页" onclick="history.back()" />${cat_name}</h2>
		</div>
		<s:iterator value="#request.booklist" status="bl">
			<div style="float: left;width: 23%;height: 250px;border: 1px solid;margin: 2px;">
				<table  height="100%" width=100%>
					<tr>
						<td rowspan="6" style="width: 150px"><img
							src="./images/${productPic}" width="150px" /></td>
						<td>
						<a href='<s:url action="bookdetail"><s:param name="product.id" value="id" /></s:url>'><h1>${productName}</h1></a>
						</td>
					</tr>
					<tr>
						<td>作者：<s:property
								value="#request.booklist.get(#bl.index).DBook.author" /></td>
					</tr>
					<tr>
						<td>出版社：<s:property
								value="#request.booklist.get(#bl.index).DBook.publishing" /></td>
					</tr>
					<tr>
						<td>${description}</td>
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
