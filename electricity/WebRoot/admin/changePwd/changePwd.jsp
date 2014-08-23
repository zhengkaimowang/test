<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>修改密码</title>
</head>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
	background:url(../../images/1.jpg) no-repeat;
	background-size: cover; 
	-moz-background-size: cover;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
</style>
<body>
<%
	String info = (String)request.getAttribute("info"); 
%>
<form action="ChangePwd"  method="post" onSubmit="return check()">
 <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2" align="right" valign="middle" scope="row" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="../../images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 用户密码修改</span></td>
              </tr>
            </table></td>
    </tr>
  <tr>
    <th width="42%" align="right" valign="middle" scope="row">&nbsp;</th>
    <td width="58%" align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th height="94" align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">
<%
	if(info != null){
%>
	   <h3><%=info%></h3>
<%		
		}	
%>
    </td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">新密码：</th>
    <td align="left" valign="middle"><input type="password" name="pwd" id="p1"></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">
重复密码：</th>
    <td align="left" valign="middle"><input type="password" id="p2" /></td>
  </tr>
  <tr>
  <th align="right" valign="middle" scope="row">&nbsp;<input type = "hidden" name = "path" value = "changePwd.jsp"></th>
    <td align="left" valign="middle"><div id="hint"></div></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="submit" value="修改" style="border:none; background:#436b92;width:80px; height:26px; font-family:'黑体';"/></td>
  </tr>
  <tr>
    <td align="center" valign="middle" colspan="2"><img src="../../images/3333.png" />&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
</table>
</form>
</body>
<script type="text/javascript" src="../../js/jquery-1.9.1.min.js"></script>
<script language="javascript">
function check(){
	if($("#p1").val() == null || $("#p1").val() == "" ){
		$("#hint").text("密码不能为空！");
			return false;
		}
	if($("#p1").val() != $("#p2").val()){
			$("#hint").text("2次密码输入不一样！");
			return false;
		}
	return true;
	}
</script>
</html>
