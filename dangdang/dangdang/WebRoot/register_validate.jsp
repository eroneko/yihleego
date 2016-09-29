
<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage="" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String rand = (String) session.getAttribute("verificationcode");
	String input = request.getParameter("rand");
	String email = request.getParameter("u.email");
	String password = request.getParameter("u.password");
	String nickname = request.getParameter("u.nickname");
	
	if (rand.equals(input)) {
%>
<body>
	<s:form action="register" name="register" id="register">
		<input type="hidden" name="u.nickname" value="<%=nickname%>">
		<input type="hidden" name="u.email" value="<%=email%>">
		<input type="hidden" name="u.password" value="<%=password%>">
	</s:form>
	<script language="JavaScript">
	
		document.register.submit();
	</script>
</body>
<%
	} else {
%>
<body>
	<s:form action="registervalidateError" id="registervalidateError" name="registervalidateError">
		<input type="hidden" name="u.nickname" value="<%=nickname%>">
		<input type="hidden" name="u.email" value="<%=email%>">

	</s:form>
	<script language="JavaScript">
	
		document.registervalidateError.submit();
	</script>
</body>
<%
	}
%>
