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

<title><s:property value="#request.product.productName" /></title>

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

#bookdetail {
	float: left;
	width: 100%;
	background-color: silver;
	padding: 0px;
	margin: 0px;
	height: 100%
}
</style>
<script type="text/javascript">
	function $(id) {
		return document.getElementById(id).value;
	}
	function checkNum() {
		var num = $("num");
		
		if (num == ""||num<=0) {
			alert("购买数量不能小于1");
			return false;
		}
	}
</script>
</head>

<body>
	<div id="bookdetail" align="center">
		<s:iterator value="#request.product" status="p">
			<div style="widows: 100%;padding: 0px;margin: 0px;height: 50px;">
				<h2 style="color:white;background-color:gray;"><input style="float: left;height: 50%;" type="button" value="返回上一页" onclick="history.back()" />${productName}——详情</h2>
			</div>
			<div style="border: 1px solid;">
				<table height="60%" width=“50%” border="0">
					<tr>
						<td rowspan="9"><img src="./images/${productPic}"
							width="300px" /></td>
						<td><a>名称：${productName}</a></td>
					</tr>
					<tr>

						<td>作者：${DBook.author}</td>
					</tr>
					<tr>
						<td>作者信息：${DBook.authorSummary}</td>
					</tr>
					<tr>
						<td>目录：${DBook.catalogue}</td>
					</tr>
					<tr>
						<td>出版社：${DBook.publishing}</td>
					</tr>
					<tr>
						<td>描述：${description}</td>
					</tr>
					<tr>
						<td>定价：${fixedPrice}元</td>
					</tr>
					<tr>
						<td>当当价：${dangPrice}元</td>
					</tr>
					<s:form action="addcart" onsubmit="return checkNum();">
					<s:hidden id="id" name="id"></s:hidden> 
					<tr>
						<s:textfield label="购买数量" type="text" name="num" id="num" value="1"> </s:textfield>
					</tr>
					<tr><td></td>
						<td><input type="submit" value="加入购物车" style="width: 100px;height: 30px;" /></td>
					</tr>
					</s:form>
				</table>
			</div>
			<br />
		
		</s:iterator>

	</div>
</body>
</html>
