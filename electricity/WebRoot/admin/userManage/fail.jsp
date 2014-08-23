<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>失败页面</title>
</head>

<body onLoad="a()">
 <%
 	String info = (String)request.getAttribute("error");	
 %>
 <input type="hidden" name="error" value="<%=info%>" id="error"/>
</body>
<script src="../../js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script language="javascript">
function a(){
	var error = $("#error").val();
	alert(error);
	window.parent.rightFrame.location.href = "StaffSearch";
}
</script>
</html>
