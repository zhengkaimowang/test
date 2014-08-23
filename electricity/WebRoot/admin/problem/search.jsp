<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*,zhuoyue.vo.*"%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>组织机构管理</title>
</head>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
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
.TABLE td{
	font-weight:bold;
	font-size:16px;}
.canshu{
	background:url(../../images/canshu.jpg);
	background-size: cover; 
	-moz-background-size: cover;
	width:100%;
	height:808px;
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
                <td width="94%" valign="bottom"><span class="STYLE1">设备管理 >> 故障报告 >> 查看参数</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr><td height="574" align="center" valign="top">
<%
	String name = null;
	String value = null;
	Record record = (Record)request.getAttribute("record");
	List<String> lname = (List<String>)request.getAttribute("parameter");
	List<String> lvalue = record.getParameter();
	Iterator<String> iter = lname.iterator();
	Iterator<String> iter1 = lvalue.iterator();
	int state = record.getState();
%>
<div class="canshu">
<table width="100%" border="0" cellspacing="0" cellpadding="0"class="TABLE">
  <tr>
    <th height="25" align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
    <td align="right" valign="middle">&nbsp;</td>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th height="147" align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
    <td align="right" valign="middle">&nbsp;</td>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th width="21%" height="31" align="right" valign="middle" scope="row">条形码<img src="../../images/point.jpg" />&nbsp;</th>
    <td width="17%" align="left" valign="middle"><%=record.getCode()%></td>
    <td width="25%" align="right" valign="middle">&nbsp;</td>
    <td width="37%" align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th height="23" align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
    <td align="right" valign="middle">&nbsp;</td>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th height="23" align="right" valign="middle" scope="row">巡检日期<img src="../../images/point.jpg" />&nbsp;</th>
    <td align="left" valign="middle"><%=record.getDate()%></td>
    <td align="right" valign="middle">&nbsp;</td>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th height="23" align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
    <td align="right" valign="middle">&nbsp;</td>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th height="24" align="right" valign="middle" scope="row">巡检人<img src="../../images/point.jpg" />&nbsp;</th>
    <td align="left" valign="middle"><%=record.getUserName()%></td>
    <td align="right" valign="middle">&nbsp;</td>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
    <td height="23" align="right" valign="middle">&nbsp;</td>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
    <td align="right" valign="middle">备注<img src="../../images/point.jpg" />&nbsp;</td>
    <td align="left" valign="middle"><%=record.getRemark()%></td>
  </tr>
  <tr>
    <th height="32" align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
    <td height="23" align="right" valign="middle">&nbsp;</td>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th height="36" align="right" valign="middle"  scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
    <td align="right" valign="middle">状态<img src="../../images/point.jpg" />&nbsp;</td>
    <td align="left" valign="middle">
<%
			if(state == 0){
%>
			未巡检
<%
			}else if(state == 1){
%>
			正常
<%
			}else{
%>
			异常
<%
			}
%>
	 </td>
  </tr>
<%
	while(iter.hasNext()){	
			name = iter.next();
			value = iter1.next();
%>
  <tr>
    <th height="20" align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
    <td height="23" align="right" valign="middle">&nbsp;</td>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th height="27" align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
    <td align="right" valign="middle"><%=name%><img src="../../images/point.jpg" />&nbsp;</td>
    <td align="left" valign="middle"><%=value%></td>
  </tr>
<%
	}
%>
</table>
</div>
</td></tr>
</table>
</body>
</html>
