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

<title>当当购物网站</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
a,a:link,a:visited,a:active,a:hover{
color: #4169E1; text-decoration:none;
font-weight:bold;
font-size: 15px;
}
#categorylist {
	float: left;
	width: 12%;
	background-color: #FFF4D7;
	padding: 0px;
	margin: 0px;
	height: 130%;
}
#main {
	float: left;
	width: 76%;
	background-color:silver;
	padding: 0px;
	margin: 0px;

}
#new {
	float: left;
	width: 76%;
	background-color:silver;
	padding: 0px;
	margin: 0px;

}

#hot {
	float: left;
	width: 76%;
	background-color:silver;
	padding: 0px;
	margin: 0px;

}
#blank {
	float: left;
	width: 12%;
	background-color:black;
	padding: 0px;
	margin: 0px;
	height: 100%;
	
}
#hotTop10 {
	float: right;
	width: 12%;
	background-color: #FFF4D7;
	padding: 0px;
	margin: 0px;
	height: 130%;
	
}
#top {
	padding: 1px;
	
}
#title{
background: #D8E4C6;
width: 100%;
}
#bottom{
background: #D8E4C6;
width: 100%;
float: left;
}
</style>
<script type="text/javascript">
function HASCS(){
	var HASCS=document.getElementById("HASCS");
	if(HASCS.value!="")
	return false;
	else
	window.location.href="showlist";
	}

</script>
</head>

<body>
	<s:hidden name="HASCS" id="HASCS"></s:hidden>
	<script type="text/javascript">HASCS()</script>
	
	<div id="top">
		<div style="float: left">
			<b>您好${LOGINUSER.nickname}，欢迎光临当当网[<%
				if (session.getAttribute("LOGINUSER") == null) {
			%><a href="login_form.jsp">登录</a>|<a href="register_form.jsp">注册</a><%} else {%><a href="logout">登出</a><%} %>]
			</b>
		</div>
		<div style="float: right">|<a href="showcart">购物车</a>|<a href="toUpdateUser">修改密码</a>|<a href="orderList">我的订单</a>|<a href="myReceiveAddress">我的地址</a>|</div>
	</div>
<!-- <div id="blank" style="float: none;"></div> -->
	<div id="title">
		<h1 style="color: #009C74;">当当购物</h1>
	</div>
	<%
		int flag = 1;
	%>
	<div id="categorylist">
		<div style="widows: 100%;padding: 0px;margin: 0px;">
			<h2 style="color:white;background-color: orange;">分类浏览</h2>
		</div>
		<s:iterator value="#request.listlist" status="st">

			<s:iterator value="#request.listlist.get(#st.index)" var="list">

				<s:iterator value="#request.categorylist" var="categorylist">

					<s:if test="#categorylist.turn+1==#list.parentId">
						<%
							if (flag == 1) {
						%>
						<div style="float:left;padding: 2px;width: 100%;">
							<b><s:property value="#categorylist.name" /></b>
						</div>
						<%
							flag = 0;
											}
						%>
					</s:if>

				</s:iterator>
				<div style="float: left;padding: 2px;">
					<a
						href='<s:url action="booklist"><s:param name="category.id" value="#list.id"/></s:url>'><s:property
							value="#list.name" /></a>|
				</div>

			</s:iterator>
			<%
				flag = 1;
			%>
		</s:iterator>
	</div>
<!-- <div id="blank" style="float: none;"></div> -->
	<div id="main">
		<div style="widows: 100%;padding: 0px;margin: 0px;">
			<h2 style="color:white;background-color:gray;">编辑推荐</h2>
		</div>
		<div>
	<s:iterator value="#request.productlist" status="pl" >
	
	<table border="0">
	<tr>
		<td rowspan="5" style="width: 100px">
			<img src="./images/${productPic}" width="100px" height="150px" />
		</td>
		<td>
			<a href='<s:url action="bookdetail"><s:param name="product.id" value="id" /></s:url>'>${productName}</a>
		</td>
	</tr>
	

	<tr>
		<td>作者：<s:property value="#request.productlist.get(#pl.index).DBook.author" /></td>
	</tr>
	<tr>
		<td>出版社：<s:property value="#request.productlist.get(#pl.index).DBook.publishing" /></td>
	</tr>

	
	<tr>
		<td>${description}</td>
	</tr>
	<tr>
		<td>定价：${fixedPrice}元  当当价：${dangPrice}元</td>
	</tr>
	</table>
	<br/>
	</s:iterator>
	</div>
	</div>
	
	
<!-- <div id="blank" style="float: none;"></div> -->	
	<div id="hotTop10">
		<div style="widows: 100%;padding: 0px;margin: 0px;">
			<h2 style="color:white;background-color:orange;">新书热卖榜</h2>
		</div>
		<s:iterator value="#request.toplist" >	
		<div style="float: left;">
		<table border="0" width="100%" >
			<tr>
				<td style="width: 100px">
					<img src="./images/${productPic}" width="100px" height="150px" />
				</td>
			</tr>
			<tr>
				<td>
					<a href='<s:url action="bookdetail"><s:param name="product.id" value="id" /></s:url>'>${productName}</a>
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
	
	
<!-- <div id="blank" style="float: none;"></div> -->
	<div id="hot">
		<div style="width: 100%;padding: 0px;margin: 0px;">
			<h2 style="color:white;background-color:gray;">热销图书</h2>

		</div>
		<s:iterator value="#request.hotlist" >	
		<div style="float: left;width: 24%;">
		<table border="0" width="80%">
			<tr>
				<td style="width: 100px">
					<img src="./images/${productPic}" width="100px" height="150px" />
				</td>
			</tr>
			<tr>
				<td>
					<a href='
					<s:url action="bookdetail">
					<s:param name="product.id" value="id" />
					
					</s:url>'>
					${productName}
					</a>
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
	
	
	<!-- <div id="blank">&nbsp;</div> -->
<!-- <div id="blank" style="float: none;"></div> -->
	<div id="new">
		<div style="width: 100%;padding: 0px;margin: 0px;">
			<h2 style="color:white;background-color:gray;">最新上架图书<a href="newlist" style="float: right;margin-top: 5px;">更多>></a></h2>

		</div>
		<s:iterator value="#request.newlist" >	
		<div style="float: left;width: 24%;">
		<table border="0" width="80%">
			<tr>
				<td style="width: 100px">
					<img src="./images/${productPic}" width="100px" height="150px" />
				</td>
			</tr>
			<tr>
				<td>
					<a href='<s:url action="bookdetail"><s:param name="product.id" value="id" /></s:url>'>${productName}</a>
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
	
	
	<!-- <div style="width:76%; float: left;" >
	<iframe src="./new.jsp" width="100%" height="100%">
	</iframe>
	</div> -->
	
	
	<div id="bottom">
	<h2 style="color:white;" align="right">201438022 叶伟毅 </h2>
	</div>
	</body>
	</html>


