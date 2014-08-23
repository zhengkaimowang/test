<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>增加部门</title>
</head>
<style type="text/css">
<!--
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
                <td width="94%" valign="bottom"><span class="STYLE1"> 用户基本信息列表 >> 添加部门</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>
    <form action="DeptInsert" method="post"><table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th width="33%" align="right" valign="middle" scope="row">&nbsp;</th>
    <td width="67%" align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">部门代号：</th>
    <td align="left" valign="middle"><input type="text" name="deptcode"  /></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">部门名称：</th>
    <td align="left" valign="middle">
  <input type="text" name="deptname" /></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">负责人：</th>
    <td align="left" valign="middle"><input type="text" name="legalman"  /></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">公司地址：</th>
    <td align="left" valign="middle"><input type="text" name="address"  /></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">联系电话：</th>
    <td align="left" valign="middle"><input type="text" name="phone"  /></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle"><input type="submit" value="保存" /><input type="reset" value="重置"  /></td>
  </tr>
</table></form>
</td>
  </tr>
</table>
</body>
</html>
