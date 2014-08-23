<%@ page contentType="text/html" pageEncoding="GBK"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>添加设备</title>
</head>
<link type="text/css" rel="stylesheet" href="calendar.css" >
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
                    <td width="94%" valign="bottom"><span class="STYLE1">添加设备</span></td>
                  </tr>
                </table></td>
                <td><div align="right"> <button id="add">添加</button><span class="STYLE1">
               </span></div> </td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
</table>
<%
	List info = (List)request.getAttribute("info");
	String projectName = (String)request.getAttribute("projectName");
	String subProjectName = (String)request.getAttribute("subProjectName");
	Iterator iter = info.iterator();
%>
<form action="EquipmentInProInsert" method="post" onSubmit="return check()">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th width="30%" align="right" valign="middle" scope="row">设备名：</th>
    <td width="70%" align="left" valign="middle"><select name="typecode" id="typecode" onChange="getText()">
      <option value="" selected="selected">请选择设备</option>
      <%
 	while(iter.hasNext()){
		pageContext.setAttribute("info",iter.next());
%>
      <option value="${info.typeCode}" >${info.typeName}</option>
      <%		
	}
 %>
    </select>
    <input type="hidden" name="typename" id="typename" 
          value="" /><div id="init1" style="float:right; width:120px; margin-right:600px;"></div></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle"></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">条形码：</th>
    <td align="left" valign="middle"><input type="text" name="code" value="" id="code"/><div id="init2" style="float:right; width:120px; margin-right:550px;"></div></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">日期：</th>
    <td align="left" valign="middle"><input type="text" name="date" id="EntTime" value="" onClick="return showCalendar('EntTime', 'y-mm-dd');"/><div id="init3" style="float:right; width:120px; margin-right:550px;"></div></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">生产商： </th>
    <td align="left" valign="middle"><input type="text" name="producer" value="" id="producer"/><div id="init4" style="float:right; width:120px; margin-right:550px;"></div></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">地址：</th>
    <td align="left" valign="middle"><input type="text" name="address" value="" id="address"/><div id="init5" style="float:right; width:120px; margin-right:550px;"></div>
      <input type="hidden" name="projectname" value="<%=projectName%>" />
    <input type="hidden" name="subname" value="<%=subProjectName%>" /></td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle">&nbsp;</td>
  </tr>
  <tr>
    <th align="right" valign="middle" scope="row">&nbsp;</th>
    <td align="left" valign="middle"><input type="submit" value="确定" /></td>
  </tr>
</table>
</form>
</body>
<script src="../../js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="calendar.js" ></script>  
<script type="text/javascript" src="calendar-zh.js" ></script>
<script type="text/javascript" src="calendar-setup.js"></script>
<script language="javascript"> 
function getText(){
var typename = $("#typecode option:selected").text();
$("#typename").val(typename);
}
</script>
<script language="javascript">
function check(){
	if($("#typecode option:selected").val() == ""){
		$("#init1").text("请选择设备名!");
		return false;
		}
	if($("#code").val() == ""){
		$("#init2").text("请填写条形码!");
		return false;
		}
	if($("#EntTime").val() == ""){
		$("#init3").text("请填写日期!");
		return false;
		}
	if($("#producer").val() == ""){
		$("#init4").text("请填写生产商!");
		return false;
		}
	if($("#address").val() == ""){
		$("#init5").text("请填写地址!");
		return false;
		}
	return true;
	}
</script>
</html>
