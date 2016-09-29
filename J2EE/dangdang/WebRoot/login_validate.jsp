
<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage="" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String rand = (String) session.getAttribute("verificationcode");
	String input = request.getParameter("rand");
	String email = request.getParameter("u.email");
	String password = request.getParameter("u.password");
	if (rand.equals(input)) {
%>
<body>
	<s:form action="login" name="login" id="login">
		<input type="hidden" name="u.email" value="<%=email%>">
		<input type="hidden" name="u.password" value="<%=password%>">
	</s:form>
	<script language="JavaScript">
		document.login.submit();
	</script>
</body>
<%
	} else {
%>
<body>
	<s:form action="loginvalidateError" id="loginvalidateError" name="loginvalidateError">
		<input type="hidden" name="u.email" value="<%=email%>">
		<%-- <input type="hidden" name="u.password"  value="<%=password%>"> --%>
	</s:form>
	<script language="JavaScript">
		document.loginvalidateError.submit();
	</script>
</body>
<%
	}
%>
