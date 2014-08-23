<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>添加设备类型</title>
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
.STYLE2{
	padding-left:250px;
	}
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
                    <td width="94%" valign="bottom"><span class="STYLE1">设备管理 >> 设备类型 >> 添加设备类型</span></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
</table>
<%
	String max = request.getParameter("max");
%>
<form action="AddType" method="post" onSubmit="return check()">
  <table width="1176px" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <th width="365" align="right" valign="middle" scope="row">&nbsp;</th>
      <td align="left" valign="middle">&nbsp;</td>
    </tr>
    <tr>
    <th width="365" align="right" valign="middle" scope="row">设备名称：</th>
    <td width="69%" align="left" valign="middle"><input type="text" name="name" id="name" value=""/>*</td>
  </tr>
    <tr>
      <th width="365" align="right" valign="middle" scope="row">&nbsp;</th>
      <td align="left" valign="middle">&nbsp;</td>
    </tr>
    <tr>
    <th width="365" align="right" valign="middle" scope="row">设备描述：</th>
    <td align="left" valign="middle"><input type="text" name="describe" id="describe"/>*
    </td>
  </tr>
    <tr>
      <th width="365" align="right" valign="middle" scope="row">&nbsp;</th>
      <td align="left" valign="middle">&nbsp;</td>
    </tr>
    <tr>
    <th width="365" align="right" valign="middle" scope="row">参数名称：</th>
    <td align="left" valign="middle"><input type="text" name="parameter" id="parameter"/>*</td>
  </tr>
    <tr>
      <th width="365" align="right" valign="middle" scope="row">&nbsp;</th>
      <td align="left" valign="middle">&nbsp;</td>
    </tr>
    <tr>
    <th width="365" align="right" valign="middle" scope="row">参数标准值：</th>
    <td align="left" valign="middle"><input type="text" name="standard" id="standard"/>*<img src="../../images/icon2_004.png" id="add" /></td>
  </tr>
  <tr>
    <th colspan="2" scope="row"><div  class="STYLE2"><input type="hidden" id="add_r" /></div>
      <input type="hidden" value="<%=max%>" name="max" />
      <input type="hidden" value="GetAllType" name="path" /></th>
    </tr>
  <tr>
    <th width="365" align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th width="365" align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle"><input type="submit" value="确定" /></td>
  </tr>
</table>
</form>
</body>
<script type="text/javascript" src="../../js/jquery-1.9.1.min.js"></script>
<script language="javascript">
  $("#add").click(function(){
    $("#add_r").before("<div style='width:300px'><br/>参数名称：<input type='text' name='parameter'/>*<br/><br/>参数标准值：<input type='text' name='standard'/>*<img src=\"../../images/pic22.gif\" onClick='$(this).parent(\"div\").remove()'/></div>");
  });
</script>
<script language="javascript">
function check(){
	if($("#name").val() == "" || $("#name").val() == "设备名称不能为空"){
		$("#name").val("设备名称不能为空");
		return false;
		}
	if($("#describe").val() == "" || $("#describe").val() == "描述不能为空"){
		$("#describe").val("描述不能为空");
		return false;
		}
	if($("#parameter").val() == "" || $("#parameter").val() == "参数名称不能为空"){
		$("#parameter").val("参数名称不能为空");
		return false;
		}
	if($("#standard").val() == "" || $("#standard").val() == "参数标准值不能为空"){
		$("#standard").val("参数标准值不能为空");
		return false;
		}
	return true;
}
</script>
</html>
