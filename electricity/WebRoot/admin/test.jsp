<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
</head>
<body>
<%
Enumeration enu = request.getParameterNames();
%>
<h1><%=request.getParameter("DeptCode")%></h1>
<h1><%=request.getParameter("UserCode")%></h1>
<%
while(enu.hasMoreElements())
{
	String paramName = (String)enu.nextElement();
%>
<h1><%=paramName%></h1>
<%}%>
</body>
</html>
