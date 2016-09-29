<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" pageEncoding="utf-8"%> 
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
<script type="text/javascript">
function validate(){
  document.getElementByIdx_x('login').submit();
}
window.load=validate();
</script>


  <% 
String verificationcode = request.getParameter("verificationcode"); 
String rand = request.getParameter("rand"); 
if(verificationcode.equals(rand)){ %>
 <body>
   <s:form action="login" name="login" id="login">
			<table border="0">
				<tr>
					<td><s:textfield label="邮箱" name="u.email" id="email"></s:textfield></td>
				</tr>
				<tr>
					<td><s:password label="密码" name="u.password" id="password" ></s:password></td>
				</tr>
				<tr>
					<td><s:textfield label="验证码" name="rand" id="rand"></s:textfield></td>
				</tr>
			</table>
		</s:form>
  </body>
  <%
out.print("<script>location.href='validate()';</script>"); 
} else{ 
out.print("<script>alert('请输入正确的验证码！');location.href='login_form.jsp';</script>"); 
} 
%> 
 
</html>
