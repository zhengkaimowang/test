<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>查看参数</title>
</head>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
	background:url(../../images/1.jpg);
	background-size: cover; 
	-moz-background-size: cover;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12; }
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	font-size: 12px;
	color: #295568;
}
-->
</style>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="../../images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1">设备管理 >> 设备类型 >> 查看参数</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="35%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">参数名</span>
        </div></td>
        <td width="65%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">标准值</span></div></td>
        </tr>
<%
	List parameterName = (List)request.getAttribute("parameterName");
	List standard = (List)request.getAttribute("standard");
	Iterator iter1 = parameterName.iterator();
	Iterator iter2 = standard.iterator();
	while(iter1.hasNext()){
		pageContext.setAttribute("name",iter1.next());
		pageContext.setAttribute("standard",iter2.next());
%>
      <tr>
        <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE19"></span>${name}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19"></span>${standard}</div></td>
        </tr>
<%
		}
%>
    </table></td>
  </tr>
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;</span></div></td>
        <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
          <tr>
            <td width="49"><div align="center">
  
    </div></td>
            <td width="49"><div align="center">
    </div></td>
            <td width="37" class="STYLE22"><div align="center">
     
	 </div></td>
            <td width="22" class="STYLE22"><div align="center"></div></td>
            <td width="35"></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
