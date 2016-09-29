<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ page import="other.forward"%>


<jsp:useBean id="fw" class="other.forward"></jsp:useBean>

<jsp:setProperty property="forwardString" name="fw" value="${forward}" />

<%
response.sendRedirect("/"+fw.getForwardString());

	/* 
	String site = new String("/" + fw.getForwardString());
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", site); */
%>
